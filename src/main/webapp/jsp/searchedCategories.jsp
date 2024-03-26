<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="%{listCategories.size()>0}">
	<table border="1">
		<tr>
			<td class="tdLabel"><label class="label">Identifiant</label></td>
			<td>Nom</td>
			<td>Description</td>
		</tr>
		<s:iterator value="listCategories">
			<tr>
				<td><s:property value="idCategorie" /></td>
				<td><s:property value="NomCategorie" /></td>
				<td><s:property value="description" /></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<s:else>
  Aucune Categorie dans la liste
</s:else>