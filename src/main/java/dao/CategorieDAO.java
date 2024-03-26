package dao;

import java.util.List;

import model.Categorie;

public interface CategorieDAO {
	public void addCategorie(Categorie categorie);
	public void updateCategorie(Categorie categorie);
	public List<Categorie> listCategories();
	public List<Categorie> selectCatByKeyword(String keyWord);
	public Categorie getCategorieById(int idCategorie);
	public void removeCategorie(int idCategorie);
}
