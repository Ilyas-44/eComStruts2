package actions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.struts2.result.PlainResult;

import com.opensymphony.xwork2.ActionSupport;

import dao.CategorieDAO;
import model.Categorie;
import service.CategorieDAOImpl;

public class CategorieAction extends ActionSupport{
	private long id;
	private String motCle;
    private String nom;
	private String description;
	private List<Categorie> listCategories = new ArrayList<Categorie>();
	private List<String> listNomCategories = new ArrayList<String>();

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Categorie> getListCategories() {
		return listCategories;
	}
	public void setListCategories(List<Categorie> listCategories) {
		this.listCategories = listCategories;
	}
	
	public List<String> getListNomCategories() {
		CategorieDAO catal=new CategorieDAOImpl();
		listCategories = catal.listCategories();
		listNomCategories = listCategories.stream()
                .map(Categorie::getNomCategorie)
                .collect(Collectors.toList());
		return listNomCategories;
	}
	public void setListNomCategories(List<String> listNomCategories) {
		this.listNomCategories = listNomCategories;
	}
	/********************* Les methodes d'action  **************/
	public String lister() {
		CategorieDAO catal=new CategorieDAOImpl();
		listCategories = catal.listCategories();
		return "success";
	}
	
	public String saisir() {
		return "success";
	}
	
	public String enregistrer() {
		CategorieDAO catal=new CategorieDAOImpl();
		Categorie newCat = new Categorie();
		newCat.setNomCategorie(nom);
		newCat.setDescription(description);
		catal.addCategorie(newCat);
		listCategories = catal.listCategories();
		return "success";
	}
	
	public String searchCategories() {
		CategorieDAO catal=new CategorieDAOImpl();
		listCategories = catal.selectCatByKeyword(motCle);
		return "success";
	}
	
	public PlainResult htmlResult() {
	    CategorieDAO catal = new CategorieDAOImpl();
	    listCategories = catal.selectCatByKeyword(motCle);
	    String html = """
	                   <%@ taglib prefix="s" uri="/struts-tags">
	                         test="{listCategories.size()>0}">
	             <table border="1"> <tr> <td
	                         <s:if
	             <td>Nom</td>
	             <tr>
	                   class="tdLabel"><label class="label">Identifiant</label></td>
	             <td>Description</td> </tr> <s:iterator value="listCategories">
	             <td><s:property value="id" /></td> <td><s:property value="nom" /></td>
	             <td><s:property value="description" /></td> </tr> </s:iterator> </table>
	             </s:if> <s:else> Aucune Categorie dans la liste </s:else>
	          """;
	    return response -> response.write(html).withContentTypeTextHtml();
	}
	
	
	
}
