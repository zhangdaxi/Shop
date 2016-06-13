package cn.edu.zucc.shop.product.action;

import cn.edu.zucc.shop.category.service.CategoryService;
import cn.edu.zucc.shop.product.service.ProductService;
import cn.edu.zucc.shop.product.vo.Product;
import cn.edu.zucc.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * ��Ʒ��action����
 */
public class ProductAction extends ActionSupport implements
		ModelDriven<Product> {

	// ���ڽ������ݵ�ģ������
	private Product product = new Product();
	// ע����Ʒ��Service
	private ProductService productService;

	// ���շ����cid
	private Integer cid;

	// ���յ�ǰ��ҳ��
	private int page;

	// ���ն��������csid
	private Integer csid;

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCid() {
		return cid;
	}

	// ע��һ�������Service
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}

	// ������Ʒ��id��ѯ��Ʒ��ִ�з���
	public String findByPid() {
		product = productService.findByPid(product.getPid());
		return "findByPid";
	}

	// ���ݷ����id����ѯ��Ʒ
	public String findByCid() {
		// List<Category> clist = categoryService.findAll();
		PageBean<Product> pageBean = productService.findByPageCid(cid, page);
		// ��pagebean���뵽ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCid";
	}
	
	//����csid����ѯ��Ʒ
	public String findByCsid(){
		//���ݶ��������ѯ��Ʒ
		PageBean<Product> pageBean = productService.findByPageCsid(csid,page);
		
		ActionContext.getContext().getValueStack().set("pageBean",pageBean);
		return "findByCsid";
	}
}