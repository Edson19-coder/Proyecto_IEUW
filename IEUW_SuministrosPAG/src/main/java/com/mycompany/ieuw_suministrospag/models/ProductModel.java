/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ieuw_suministrospag.models;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ProductModel {
    private int idproduct;
    private String productName;
    private int productCategory;
    private int productSubCategory;
    private float productCosto;
    private String productDescripcion;
    private String productMaterial;
    private String productMedidas;
    private String productUnidadEmpaque;
    private String productMedidaCaja;
    private String productPesoCaja;
    private String productImgPath1;
    private String productImgPath2;

    public ProductModel() {
    }

    public ProductModel(int idproduct, String productName, int productCategory, int productSubCategory, float productCosto, String productDescripcion, String productMaterial, String productMedidas, String productUnidadEmpaque, String productMedidaCaja, String productPesoCaja, String productImgPath1, String productImgPath2) {
        this.idproduct = idproduct;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productSubCategory = productSubCategory;
        this.productCosto = productCosto;
        this.productDescripcion = productDescripcion;
        this.productMaterial = productMaterial;
        this.productMedidas = productMedidas;
        this.productUnidadEmpaque = productUnidadEmpaque;
        this.productMedidaCaja = productMedidaCaja;
        this.productPesoCaja = productPesoCaja;
        this.productImgPath1 = productImgPath1;
        this.productImgPath2 = productImgPath2;
    }

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(int productCategory) {
        this.productCategory = productCategory;
    }

    public int getProductSubCategory() {
        return productSubCategory;
    }

    public void setProductSubCategory(int productSubCategory) {
        this.productSubCategory = productSubCategory;
    }

    public float getProductCosto() {
        return productCosto;
    }

    public void setProductCosto(float productCosto) {
        this.productCosto = productCosto;
    }

    public String getProductDescripcion() {
        return productDescripcion;
    }

    public void setProductDescripcion(String productDescripcion) {
        this.productDescripcion = productDescripcion;
    }

    public String getProductMaterial() {
        return productMaterial;
    }

    public void setProductMaterial(String productMaterial) {
        this.productMaterial = productMaterial;
    }

    public String getProductMedidas() {
        return productMedidas;
    }

    public void setProductMedidas(String productMedidas) {
        this.productMedidas = productMedidas;
    }

    public String getProductUnidadEmpaque() {
        return productUnidadEmpaque;
    }

    public void setProductUnidadEmpaque(String productUnidadEmpaque) {
        this.productUnidadEmpaque = productUnidadEmpaque;
    }

    public String getProductMedidaCaja() {
        return productMedidaCaja;
    }

    public void setProductMedidaCaja(String productMedidaCaja) {
        this.productMedidaCaja = productMedidaCaja;
    }

    public String getProductPesoCaja() {
        return productPesoCaja;
    }

    public void setProductPesoCaja(String productPesoCaja) {
        this.productPesoCaja = productPesoCaja;
    }

    public String getProductImgPath1() {
        return productImgPath1;
    }

    public void setProductImgPath1(String productImgPath1) {
        this.productImgPath1 = productImgPath1;
    }

    public String getProductImgPath2() {
        return productImgPath2;
    }

    public void setProductImgPath2(String productImgPath2) {
        this.productImgPath2 = productImgPath2;
    }
    
    
}
