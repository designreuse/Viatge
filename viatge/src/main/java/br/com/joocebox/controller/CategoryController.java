package br.com.joocebox.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.joocebox.model.Category;
import br.com.joocebox.service.DashboardFacade;

@Controller
@Transactional(propagation = Propagation.REQUIRED)
@RequestMapping("/auth")
public class CategoryController {
    final static Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    public DashboardFacade dashboardFacade;
    
    @RequestMapping("category")
    public String getMenuCategory(Model mv) {
        List<Category> category = dashboardFacade.getCategoryList();
        mv.addAttribute("category", category);
        return "category/categoryList";
    }
    
    @RequestMapping("newCategory")
    public String newCategory(Model model) {
        model.addAttribute("categoryForm", new Category());
        model.addAttribute("action", "addCategory");
        return "category/updateCategory";
    }
    
    @RequestMapping(value = "addCategory", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category") @Valid Category category, BindingResult result, HttpServletRequest req, RedirectAttributes redirectAttributes, Model model) {

        if (result.hasErrors()) {
            req.setAttribute("validator", true);
            return newCategory(model);
        } else {
            category.setCtActive(1);
            category.getCtName().trim();
            dashboardFacade.addCategory(category);
            redirectAttributes.addFlashAttribute("message", "A categoria " + category.getCtName() + " foi adicionada com sucesso!");
            logger.info("Categoria " + category.getCtName() + " foi adicionada para agência: " + dashboardFacade.getAgency());
            return "redirect:category";
        }
    
    }
    
    /**
     * Ação responsável por apresentar o formulário da categoria
     * @param id
     * @param model
     * @return 
     */
    @RequestMapping(value = "editCategory", method = RequestMethod.GET)
    public String editCategory(Long id, Model model) {
        model.addAttribute("categoryForm", dashboardFacade.getCategoryId(id));
        model.addAttribute("action", "updateCategory");
        return "category/updateCategory";
    }
    
    /**
     * Ação responsável por atualizar os dados enviados pelo formulário.
     * 
     * @param category
     * @param result
     * @param id
     * @param ctName
     * @param model
     * @return 
     */
    @RequestMapping(value = "updateCategory", method = RequestMethod.POST)
    public String updateCategory(@ModelAttribute("categoryForm") @Valid Category category, BindingResult result, @RequestParam Long id, @RequestParam String ctName, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("validator", true);
            return editCategory(id, model);
        } else {
            dashboardFacade.categoryUpdate(ctName, id);
            logger.info("A categoria " + category.getIdCategory() + " pertencente a agência " + dashboardFacade.getAgency() + " foi adicionada.");
            return "redirect:category";
        }
    }
}
