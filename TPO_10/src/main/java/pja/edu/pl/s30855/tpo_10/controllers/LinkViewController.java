package pja.edu.pl.s30855.tpo_10.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pja.edu.pl.s30855.tpo_10.models.AccessLinkDTO;
import pja.edu.pl.s30855.tpo_10.models.Link;
import pja.edu.pl.s30855.tpo_10.models.LinkRequest;
import pja.edu.pl.s30855.tpo_10.models.LinkResponse;
import pja.edu.pl.s30855.tpo_10.services.LinkService;


@Controller
public class LinkViewController {

    private final LinkService linkService;


    public LinkViewController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("linkRequest", new LinkRequest());
        return "index";
    }

    @PostMapping("/create")
    public String handleCreate(@Valid @ModelAttribute("linkRequest") LinkRequest linkRequest,
                               BindingResult result) {

        if (result.hasErrors()) {
            return "index";
        }
        linkService.createLink(linkRequest);
        return "redirect:/success";
    }

    @GetMapping("/access")
    public String showAccessForm(Model model) {
        model.addAttribute("linkRequest", new LinkRequest());
        return "access";
    }

    @PostMapping("/access")
    public String handleAccess(@Valid @ModelAttribute("linkRequest") AccessLinkDTO request,
                               BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("error", "Invalid name or password");
            return "access";
        }

        String name = request.getName();
        String password = request.getPassword();


        LinkResponse link = linkService.getLinkByNameAndPassword(name.trim(), password.trim());


        if (link == null) {
            model.addAttribute("error", "Link doesn't exist");
            return "access";
        }

        model.addAttribute("link", link);
        return "details";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {

        Link link = linkService.getLinkEntityById(id);

        if (link == null) {
            return "edit";
        }

        LinkRequest form = new LinkRequest(link.getName(), link.getTargetUrl(), link.getPassword());
        model.addAttribute("linkRequest", form);
        model.addAttribute("linkId", id);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String handleEdit(@PathVariable String id,
                             @ModelAttribute("linkRequest") @Valid LinkRequest form,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("linkId", id);
            return "edit";
        }

        try {
            linkService.updateLink(id, form);
        } catch (IllegalArgumentException ex) {
            result.rejectValue("targetUrl", "error.linkRequest", ex.getMessage());
            model.addAttribute("linkId", id);
            return "edit";
        }

        return "redirect:/access?edited";
    }

    @GetMapping("/deleted")
    public String showDeletedPage() {
        return "deleted";
    }

    @PostMapping("/delete/{id}")
    public String handleDelete(@PathVariable String id,
                               @RequestParam(required = false) String password, Model model) {
        try {
            linkService.deleteLink(id, password);
            return "redirect:/deleted";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Wrong password or link not found.");
            return "access";
        }
    }


    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }
}
