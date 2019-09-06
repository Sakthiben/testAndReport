package com.karya.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.karya.bean.AssetBean;
import com.karya.bean.AssetMovementBean;
import com.karya.bean.ChequeTemplateBean;
import com.karya.bean.PeriodClosingVoucherBean;
import com.karya.bean.TrialBalanceBean;
import com.karya.model.Asset001MB;
import com.karya.model.AssetMovement001MB;
import com.karya.model.ChequeTemplate001MB;
import com.karya.model.PeriodClosingVoucher001MB;
import com.karya.service.IAssetService;
import com.karya.service.IToolsService;

@Controller
@RequestMapping(value="Tools")
public class ToolsController extends BaseController {
	
	@Resource(name="toolsservice")
	private IToolsService toolsservice;
	
	@Resource(name="assetservice")
	private IAssetService assetservice;
	
	private @Value("${account.type}") String[] bankName;

	@RequestMapping(value = "/tools", method = RequestMethod.GET)
	public ModelAndView accountingstatements(@ModelAttribute("command")  TrialBalanceBean trialbalancebean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	return new ModelAndView("tools", model);
    }
	
	@RequestMapping(value = "/periodclosingvoucher", method = RequestMethod.GET)
	public ModelAndView periodclosingvoucher(@ModelAttribute("command")  PeriodClosingVoucherBean periodclosingvoucherbean,
		BindingResult result, String mode) {
	Map<String, Object> model = new HashMap<String, Object>();
	if(mode != null) {
		if(mode.equals("New")) {
			model.put("msg", submitSuccess); 
		} else if(mode.equals("Old")) {
			model.put("msg", updateSuccess);
		} else if(mode.equals("Delete")) {
			model.put("msg", deleteSuccess);
		}
	}
	model.put("periodclosingvoucherlist",  prepareListofBeanperiodclosingvoucher(toolsservice.periodclosingvoucherlist()));
	return new ModelAndView("periodclosingvoucher", model);
    }
	
	@RequestMapping(value = "/addperiodclosingvoucher", method = RequestMethod.POST)
	public ModelAndView addperiodclosingvoucher(@ModelAttribute("command") @Valid PeriodClosingVoucherBean periodclosingvoucherbean,
			BindingResult result) {
		PeriodClosingVoucher001MB periodclosingvouchermb = prepareModelperiodclosingvoucher(periodclosingvoucherbean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("periodclosingvoucherlist",  prepareListofBeanperiodclosingvoucher(toolsservice.periodclosingvoucherlist()));
		if (result.hasErrors()) {
			return new ModelAndView("periodclosingvoucher", model);
        }
		toolsservice.addperiodclosingvoucher(periodclosingvouchermb);
		if(periodclosingvoucherbean.getId()== 0){
			return new ModelAndView("redirect:/Tools/periodclosingvoucher?mode=New");
		} else {
			return new ModelAndView("redirect:/Tools/periodclosingvoucher?mode=Old");
		}
	}
	
	@RequestMapping(value = "/editperiodclosingvoucher", method = RequestMethod.GET)
	public ModelAndView editsalestaxes(@ModelAttribute("command")  PeriodClosingVoucherBean periodclosingvoucherbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("periodclosingvoucherlists", preparesalestaxesEdit(toolsservice.getperiodclosingvoucher(periodclosingvoucherbean.getId())));
		model.put("periodclosingvoucherlist",  prepareListofBeanperiodclosingvoucher(toolsservice.periodclosingvoucherlist()));
		return new ModelAndView("periodclosingvoucher", model);
	}
	
	@RequestMapping(value = "/deleteperiodclosingvoucher", method = RequestMethod.GET)
	public ModelAndView deletesalestaxes(@ModelAttribute("command")  PeriodClosingVoucherBean periodclosingvoucherbean,
			BindingResult result) {
		toolsservice.deleteperiodclosingvoucher(periodclosingvoucherbean.getId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("periodclosingvoucher", null);
		model.put("periodclosingvoucherlist",  prepareListofBeanperiodclosingvoucher(toolsservice.periodclosingvoucherlist()));
		return new ModelAndView("redirect:/Tools/periodclosingvoucher?mode=Delete" );
	}
	
	/*@RequestMapping(value = "/tools", method = RequestMethod.GET)
	public ModelAndView accountingstatements(@ModelAttribute("command")  TrialBalanceBean trialbalancebean,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	return new ModelAndView("tools", model);
    }
	*/
	//List Period Closing Voucher
	
	private List<PeriodClosingVoucherBean> prepareListofBeanperiodclosingvoucher(List<PeriodClosingVoucher001MB> periodclosingvouchermb){
		List<PeriodClosingVoucherBean> beans = null;
		if(periodclosingvouchermb != null && !periodclosingvouchermb.isEmpty()){
			beans = new ArrayList<PeriodClosingVoucherBean>();
			PeriodClosingVoucherBean bean = null;
			for(PeriodClosingVoucher001MB periodclosingvoucherlist : periodclosingvouchermb){
				bean = new PeriodClosingVoucherBean();
				bean.setId(periodclosingvoucherlist.getId());
				bean.setTransactiondate(periodclosingvoucherlist.getTransactiondate());
				bean.setClosingaccounthead(periodclosingvoucherlist.getClosingaccounthead());
				bean.setPostingdate(periodclosingvoucherlist.getPostingdate());
				bean.setClosingfiscalyear(periodclosingvoucherlist.getClosingfiscalyear());
				bean.setCompany(periodclosingvoucherlist.getCompany());
				bean.setRemarks(periodclosingvoucherlist.getRemarks());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	// Add period closing voucher
	private PeriodClosingVoucher001MB prepareModelperiodclosingvoucher(PeriodClosingVoucherBean periodclosingvoucherbean) {
		PeriodClosingVoucher001MB periodclosingvouchermb = new PeriodClosingVoucher001MB();
		periodclosingvouchermb.setId(periodclosingvoucherbean.getId());
		periodclosingvouchermb.setTransactiondate(periodclosingvoucherbean.getTransactiondate());
		periodclosingvouchermb.setClosingaccounthead(periodclosingvoucherbean.getClosingaccounthead());
		periodclosingvouchermb.setPostingdate(periodclosingvoucherbean.getPostingdate());
		periodclosingvouchermb.setClosingfiscalyear(periodclosingvoucherbean.getClosingfiscalyear());
		periodclosingvouchermb.setCompany(periodclosingvoucherbean.getCompany());
		periodclosingvouchermb.setRemarks(periodclosingvoucherbean.getRemarks());
		return periodclosingvouchermb;
	}
	
	//Edit Period Closing Voucher
	private PeriodClosingVoucherBean preparesalestaxesEdit(PeriodClosingVoucher001MB periodclosingvouchermb) {
		PeriodClosingVoucherBean bean = new PeriodClosingVoucherBean();
		bean.setId(periodclosingvouchermb.getId());
		bean.setTransactiondate(periodclosingvouchermb.getTransactiondate());
		bean.setClosingaccounthead(periodclosingvouchermb.getClosingaccounthead());
		bean.setPostingdate(periodclosingvouchermb.getPostingdate());
		bean.setClosingfiscalyear(periodclosingvouchermb.getClosingfiscalyear());
		bean.setCompany(periodclosingvouchermb.getCompany());
		bean.setRemarks(periodclosingvouchermb.getRemarks());
		return bean;
	}
	
	
	@RequestMapping(value = "/assetmovement", method = RequestMethod.GET)
	public ModelAndView assetmovement(@ModelAttribute("command")  AssetMovementBean assetmovementbean,
		BindingResult result, String mode) {
	Map<String, Object> model = new HashMap<String, Object>();
	if(mode != null) {
		if(mode.equals("New")) {
			model.put("msg", submitSuccess); 
		} else if(mode.equals("Old")) {
			model.put("msg", updateSuccess);
		} else if(mode.equals("Delete")) {
			model.put("msg", deleteSuccess);
		}
	}
	model.put("assetmovementlist",  prepareListofBeanassetmovement(toolsservice.assetmovementlist()));
	model.put("assetlist",  prepareListofBeanAsset(assetservice.assetlist()));
	return new ModelAndView("assetmovement", model);
    }
	
	@RequestMapping(value = "/addassetmovement", method = RequestMethod.POST)
	public ModelAndView addassetmovement(@ModelAttribute("command") @Valid AssetMovementBean assetmovementbean,
			BindingResult result) {
		AssetMovement001MB assetmovementmb = prepareModelassetmovement(assetmovementbean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("assetmovementlist",  prepareListofBeanassetmovement(toolsservice.assetmovementlist()));
		model.put("assetlist",  prepareListofBeanAsset(assetservice.assetlist()));
		if (result.hasErrors()) {
			return new ModelAndView("assetmovement", model);
        }
		toolsservice.addassetmovement(assetmovementmb);
		if(assetmovementbean.getId()== 0){
			return new ModelAndView("redirect:/Tools/assetmovement?mode=New");
		} else {
			return new ModelAndView("redirect:/Tools/assetmovement?mode=Old");
		}
	}
	
	@RequestMapping(value = "/editassetmovement", method = RequestMethod.GET)
	public ModelAndView editassetmovement(@ModelAttribute("command")  AssetMovementBean assetmovementbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("assetmovementlists", prepareAssetmovementEdit(toolsservice.getassetmovement(assetmovementbean.getId())));
		model.put("assetmovementlist",  prepareListofBeanassetmovement(toolsservice.assetmovementlist()));
		model.put("assetlist",  prepareListofBeanAsset(assetservice.assetlist()));
		return new ModelAndView("assetmovement", model);
	}
	
	@RequestMapping(value = "/deleteassetmovement", method = RequestMethod.GET)
	public ModelAndView deleteassetmovement(@ModelAttribute("command")  AssetMovementBean assetmovementbean,
			BindingResult result) {
		toolsservice.deleteassetmovement(assetmovementbean.getId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("assetmovement", null);
		model.put("assetmovementlist",  prepareListofBeanassetmovement(toolsservice.assetmovementlist()));
		model.put("assetlist",  prepareListofBeanAsset(assetservice.assetlist()));
		return new ModelAndView("redirect:/Tools/assetmovement?mode=Delete");
	}
	
	
	
/*	@RequestMapping(value = "/filechequetemplate", method = RequestMethod.POST)
	public ModelAndView filechequetemplate(@ModelAttribute("command") ChequeTemplateBean chequetemplatebean,
			BindingResult result) throws IOException {
		String user = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getName();
		filemanagerbean.setLoginuser(user);
		chequetemplatebean.setFilename(chequetemplatebean.getFile().getOriginalFilename());
		chequetemplatebean.setContent(chequetemplatebean.getFile().getBytes());
		chequetemplatebean.setContenttype(chequetemplatebean.getFile().getContentType());
		ChequeTemplate001MB chequetemplate001mb = preparechequetemplateModel(chequetemplatebean);
		toolsservice.addchequetemplate(chequetemplate001mb);
		//FileService.addfiles(file);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("chequetemplateList",  preparechequetemplateListofBean(toolsservice.listchequetemplate()));
		return new ModelAndView("chequetemplate", model);
	}
	
	
	@RequestMapping("/downloadcheque/{cheqId}")
	public String downloadcheque(@PathVariable("cheqId") int cheqId, HttpServletResponse response) {
		ChequeTemplate001MB chequetemplate001mb = toolsservice.getchequetemplate(cheqId);
		try {
			response.setHeader("Content-Disposition", "inline;filename=\"" +chequetemplate001mb.getFilename()+ "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType(chequetemplate001mb.getContenttype());
			InputStream is = null;
			is = new ByteArrayInputStream(chequetemplate001mb.getContent());
			IOUtils.copy(is, out);
			out.flush();
			out.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}*/
	
	/*@RequestMapping(value = "/deletecheque/{cheqId}", method = RequestMethod.GET)
	public ModelAndView deletecheque(@ModelAttribute("command") ChequeTemplateBean chequetemplatebean,
			BindingResult result) {
		toolsservice.deletechequetemplate(chequetemplatebean.getCheqId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("file", null);
		model.put("chequetemplateList",  preparechequetemplateListofBean(toolsservice.listchequetemplate()));
		return new ModelAndView("chequetemplate", model);	
	}*/
	
	@RequestMapping(value = "/chequetemplate", method = RequestMethod.GET)
	public ModelAndView chequetemplate(@ModelAttribute("command")  ChequeTemplateBean chequetemplatebean,
		BindingResult result, String mode) {
	Map<String, Object> model = new HashMap<String, Object>();
	if(mode != null) {
		if(mode.equals("New")) {
			model.put("msg", submitSuccess); 
		} else if(mode.equals("Old")) {
			model.put("msg", updateSuccess);
		} else if(mode.equals("Delete")) {
			model.put("msg", deleteSuccess);
		}
	}
	
	model.put("chequeaccountList",  bankName);
	model.put("chequetemplateList",  preparechequetemplateListofBean(toolsservice.listchequetemplate()));
	return new ModelAndView("chequetemplate", model);
    }
	
	
	@RequestMapping(value = "/deletechequetemplate", method = RequestMethod.GET)
	public ModelAndView deletechequetemplate(@ModelAttribute("command")   ChequeTemplateBean chequetemplatebean,
			BindingResult result) {
		toolsservice.deletechequetemplate(chequetemplatebean.getCheqId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("chequetemplateList",  preparechequetemplateListofBean(toolsservice.listchequetemplate()));
		return new ModelAndView("redirect:/Tools/chequetemplate?mode=Delete");
	}
	
	@RequestMapping(value = "/editchequetemplate", method = RequestMethod.GET)
	public ModelAndView editchequetemplate(@ModelAttribute("command")  ChequeTemplateBean chequetemplatebean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("chequetemplateEdit", preparechequetemplateEdit(toolsservice.getchequetemplate(chequetemplatebean.getCheqId())));
		model.put("chequeaccountList",  bankName);
		model.put("chequetemplateList",  preparechequetemplateListofBean(toolsservice.listchequetemplate()));
		return new ModelAndView("chequetemplate", model);
	}
	
	@RequestMapping(value = "/savechequetemplate", method = RequestMethod.POST)
	public ModelAndView savechequetemplate(@ModelAttribute("command") @Valid ChequeTemplateBean chequetemplatebean,
			BindingResult result) {
		ChequeTemplate001MB chequetemplate001mb = preparechequetemplateModel(chequetemplatebean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("chequeaccountList",  bankName);
		model.put("chequetemplateList",  preparechequetemplateListofBean(toolsservice.listchequetemplate()));
			if (result.hasErrors()) {
			return new ModelAndView("chequetemplate", model);
        }
			toolsservice.addchequetemplate(chequetemplate001mb);
		if(chequetemplatebean.getCheqId()== 0){
			return new ModelAndView("redirect:/Tools/chequetemplate?mode=New");
		} else {
			return new ModelAndView("redirect:/Tools/chequetemplate?mode=Old");
		}
	}
	
	
	private ChequeTemplateBean preparechequetemplateEdit(ChequeTemplate001MB cheque) {
		ChequeTemplateBean bean = new ChequeTemplateBean();
		bean.setCheqId(cheque.getCheqId());
		bean.setAccnodistfromLeft(cheque.getAccnodistfromLeft());
		bean.setAccnodistfromTop(cheque.getAccnodistfromTop());
		bean.setAmtfdistfromLeft(cheque.getAmtfdistfromLeft());
		bean.setAmtfdistfromTop(cheque.getAmtfdistfromTop());
		bean.setAmtwdistfromLeft(cheque.getAmtwdistfromLeft());
		bean.setAmtwdistfromTop(cheque.getAmtwdistfromTop());
		bean.setAmtwlineSpace(cheque.getAmtwlineSpace());
		bean.setAmtwWidth(cheque.getAmtwWidth());
		bean.setDtdistfromLeft(cheque.getDtdistfromLeft());
		bean.setDtdistfromTop(cheque.getDtdistfromTop());
		bean.setPaydistfromLeft(cheque.getPaydistfromLeft());
		bean.setPaydistfromTop(cheque.getPaydistfromTop());
		bean.setPrmaccountName(cheque.getPrmaccountName());
		bean.setPrmcheqHeight(cheque.getPrmcheqHeight());
		bean.setPrmcheqSize(cheque.getPrmcheqSize());
		bean.setPrmcheqWidth(cheque.getPrmcheqWidth());
		bean.setPrmdistfromLeft(cheque.getPrmdistfromLeft());
		bean.setPrmdistfromTop(cheque.getPrmdistfromTop());
		bean.setPrmisaccPay(cheque.isPrmisaccPay());
		bean.setPrmmesgtoShow(cheque.getPrmmesgtoShow());
		bean.setScanCheq(cheque.getScanCheq());
		bean.setSignposdistfromLeft(cheque.getSignposdistfromLeft());
		bean.setSignposdistfromTop(cheque.getSignposdistfromTop());
		
		return bean;
	}
	
	private ChequeTemplate001MB preparechequetemplateModel(ChequeTemplateBean chequetemplatebean) {
		ChequeTemplate001MB chequetemplate001mb = new ChequeTemplate001MB();
		if(chequetemplatebean.getCheqId()!=0){
			chequetemplate001mb.setCheqId(chequetemplatebean.getCheqId());
		
		}
		
		chequetemplate001mb.setAccnodistfromLeft(chequetemplatebean.getAccnodistfromLeft());
		chequetemplate001mb.setAccnodistfromTop(chequetemplatebean.getAccnodistfromTop());
		chequetemplate001mb.setAmtfdistfromLeft(chequetemplatebean.getAmtfdistfromLeft());
		chequetemplate001mb.setAmtfdistfromTop(chequetemplatebean.getAmtfdistfromTop());
		chequetemplate001mb.setAmtwdistfromLeft(chequetemplatebean.getAmtwdistfromLeft());
		chequetemplate001mb.setAmtwdistfromTop(chequetemplatebean.getAmtwdistfromTop());
		chequetemplate001mb.setAmtwlineSpace(chequetemplatebean.getAmtwlineSpace());
		chequetemplate001mb.setAmtwWidth(chequetemplatebean.getAmtwWidth());
		chequetemplate001mb.setDtdistfromLeft(chequetemplatebean.getDtdistfromLeft());
		chequetemplate001mb.setDtdistfromTop(chequetemplatebean.getDtdistfromTop());
		chequetemplate001mb.setPaydistfromLeft(chequetemplatebean.getPaydistfromLeft());
		chequetemplate001mb.setPaydistfromTop(chequetemplatebean.getPaydistfromTop());
		chequetemplate001mb.setPrmaccountName(chequetemplatebean.getPrmaccountName());
		chequetemplate001mb.setPrmcheqHeight(chequetemplatebean.getPrmcheqHeight());
		chequetemplate001mb.setPrmcheqSize(chequetemplatebean.getPrmcheqSize());
		chequetemplate001mb.setPrmcheqWidth(chequetemplatebean.getPrmcheqWidth());
		chequetemplate001mb.setPrmdistfromLeft(chequetemplatebean.getPrmdistfromLeft());
		chequetemplate001mb.setPrmdistfromTop(chequetemplatebean.getPrmdistfromTop());
		chequetemplate001mb.setPrmisaccPay(chequetemplatebean.isPrmisaccPay());
		chequetemplate001mb.setPrmmesgtoShow(chequetemplatebean.getPrmmesgtoShow());
		chequetemplate001mb.setScanCheq(chequetemplatebean.getScanCheq());
		chequetemplate001mb.setSignposdistfromLeft(chequetemplatebean.getSignposdistfromLeft());
		chequetemplate001mb.setSignposdistfromTop(chequetemplatebean.getSignposdistfromTop());
		
		return chequetemplate001mb;	
		
	}
	
	private List<ChequeTemplateBean> preparechequetemplateListofBean(List<ChequeTemplate001MB> chequetemplate001mb ) {
		List<ChequeTemplateBean> beans = null;
		if(chequetemplate001mb != null && !chequetemplate001mb.isEmpty()){
			beans = new ArrayList<ChequeTemplateBean>();
			ChequeTemplateBean bean = null;
			for(ChequeTemplate001MB cheque : chequetemplate001mb){
				bean = new ChequeTemplateBean();
				bean.setCheqId(cheque.getCheqId());
				bean.setAccnodistfromLeft(cheque.getAccnodistfromLeft());
				bean.setAccnodistfromTop(cheque.getAccnodistfromTop());
				bean.setAmtfdistfromLeft(cheque.getAmtfdistfromLeft());
				bean.setAmtfdistfromTop(cheque.getAmtfdistfromTop());
				bean.setAmtwdistfromLeft(cheque.getAmtwdistfromLeft());
				bean.setAmtwdistfromTop(cheque.getAmtwdistfromTop());
				bean.setAmtwlineSpace(cheque.getAmtwlineSpace());
				bean.setAmtwWidth(cheque.getAmtwWidth());
				bean.setDtdistfromLeft(cheque.getDtdistfromLeft());
				bean.setDtdistfromTop(cheque.getDtdistfromTop());
				bean.setPaydistfromLeft(cheque.getPaydistfromLeft());
				bean.setPaydistfromTop(cheque.getPaydistfromTop());
				bean.setPrmaccountName(cheque.getPrmaccountName());
				bean.setPrmcheqHeight(cheque.getPrmcheqHeight());
				bean.setPrmcheqSize(cheque.getPrmcheqSize());
				bean.setPrmcheqWidth(cheque.getPrmcheqWidth());
				bean.setPrmdistfromLeft(cheque.getPrmdistfromLeft());
				bean.setPrmdistfromTop(cheque.getPrmdistfromTop());
				bean.setPrmisaccPay(cheque.isPrmisaccPay());
				bean.setPrmmesgtoShow(cheque.getPrmmesgtoShow());
				bean.setScanCheq(cheque.getScanCheq());
				bean.setSignposdistfromLeft(cheque.getSignposdistfromLeft());
				bean.setSignposdistfromTop(cheque.getSignposdistfromTop());
				
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	//Asset List
	private List<AssetBean> prepareListofBeanAsset(List<Asset001MB> assetmb){
		List<AssetBean> beans = null;
		if(assetmb != null && !assetmb.isEmpty()){
			beans = new ArrayList<AssetBean>();
			AssetBean bean = null;
			for(Asset001MB assetlist : assetmb){
				bean = new AssetBean();
				bean.setId(assetlist.getId());
				bean.setAsset(assetlist.getAsset());
				beans.add(bean);
			}
		}
		return beans;
	 }
	
	//List Asset Movement
	
	private List<AssetMovementBean> prepareListofBeanassetmovement(List<AssetMovement001MB> assetmovementmb){
		List<AssetMovementBean> beans = null;
		if(assetmovementmb != null && !assetmovementmb.isEmpty()){
			beans = new ArrayList<AssetMovementBean>();
			AssetMovementBean bean = null;
			for(AssetMovement001MB assetmovementlist : assetmovementmb){
				bean = new AssetMovementBean();
				bean.setId(assetmovementlist.getId());
				bean.setTransactiondate(assetmovementlist.getTransactiondate());
				bean.setAsset(assetmovementlist.getAsset());
				bean.setCompany(assetmovementlist.getCompany());
				bean.setTargetwarehouse(assetmovementlist.getTargetwarehouse());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	// Add Asset movememnt
	private AssetMovement001MB prepareModelassetmovement(AssetMovementBean assetmovementbean) {
		AssetMovement001MB assetmovementmb = new AssetMovement001MB();
		assetmovementmb.setId(assetmovementbean.getId());
		assetmovementmb.setTransactiondate(assetmovementbean.getTransactiondate());
		assetmovementmb.setAsset(assetmovementbean.getAsset());
		assetmovementmb.setCompany(assetmovementbean.getCompany());
		assetmovementmb.setTargetwarehouse(assetmovementbean.getTargetwarehouse());
		return assetmovementmb;
	}
	
	//Edit Asset Movement
	private AssetMovementBean prepareAssetmovementEdit(AssetMovement001MB assetmovementmb) {
		AssetMovementBean bean = new AssetMovementBean();
		bean.setId(assetmovementmb.getId());
		bean.setTransactiondate(assetmovementmb.getTransactiondate());
		bean.setAsset(assetmovementmb.getAsset());
		bean.setCompany(assetmovementmb.getCompany());
		bean.setTargetwarehouse(assetmovementmb.getTargetwarehouse());
		return bean;
	}
	
	
}
