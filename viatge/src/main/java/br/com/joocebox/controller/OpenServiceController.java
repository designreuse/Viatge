package br.com.joocebox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.joocebox.model.SaleType;
import br.com.joocebox.model.ServiceItem;
import br.com.joocebox.model.views.VwOpenService;
import br.com.joocebox.service.ServiceFacade;
import br.com.joocebox.service.ServiceItemFacade;

@Controller
@Transactional(propagation = Propagation.REQUIRED)
@RequestMapping("/auth")
public class OpenServiceController {

	@Autowired
	private ServiceFacade serviceFacade;
	
	@Autowired
	private ServiceItemFacade serviceItemFacade;
	
    /**
     * Carrega na tela as labels, assim como os contadores de cada etapa de viagem.  
     * @param model
     */
	@RequestMapping("/serviceList")
	public ModelAndView getMenuServiceList(Model model) {
		ModelAndView mv = new ModelAndView("service/serviceList");
		List<VwOpenService> openServiceList = serviceFacade.getOpenServiceList();		
		mv.addObject("serviceListRegister", openServiceList);
		mv.addObject("ListSize", openServiceList.size());
		mv.addObject("nextToTravel", nextToTravel(openServiceList));
		avgBudgets(model);
		countOfBudgets(model);	
		return mv;
	}
	
	/**
	 * Realiza a verificação de passageiros que estão prestes a viajar. 
	 * @param openServiceList
	 * @return int
	 */
	public int nextToTravel(List<VwOpenService> openServiceList) {
		int nextToTravel = 0;
		for(VwOpenService openService : openServiceList){
			if(openService.getSite()){
				nextToTravel ++;
			}				
		}
		return nextToTravel;
	}
	
    /**
     * Ação responsável por calcular o valor total dos orçamentos enviados
     * @param model
     */
	public void avgBudgets(Model model) {
		List<ServiceItem> serviceItemList = serviceItemFacade.getAllServiceItems();
		
		Double amount = 0.00;
		
		for (ServiceItem si : serviceItemList) {
			if (si.getSaleType() == SaleType.SEND_BUDGET) {
				Double price = si.getValueNegotiated();
				amount += price;
			}
		}
		model.addAttribute("totalAmount", amount);
	}
	
    /**
     * Ação responsável pela somar os valores de cada atendimento em aberto e exibir na tela.
     * @param model
     */
	public void countOfBudgets(Model model){
		List<ServiceItem> serviceItemList = serviceItemFacade.getAllServiceItems();
		
		int send_budget_var = 0;
		int submitted_budget_var = 0;
		
		for (ServiceItem serviceItem : serviceItemList) {
			if(serviceItem.getSaleType() == SaleType.SEND_BUDGET){
				send_budget_var ++;
				
			}else if(serviceItem.getSaleType() == SaleType.SUBMITTED_BUDGET){
				submitted_budget_var ++;
			}
		}
		model.addAttribute("send_budget_div", send_budget_var);
		model.addAttribute("submitted_budget_div", submitted_budget_var);
	}

}
