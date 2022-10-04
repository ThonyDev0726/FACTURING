/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Model.PAG_SERVICIOS;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_pagina_servicios {

    public List listar();

    public PAG_SERVICIOS list(int idPag_servicios);

    public String add(PAG_SERVICIOS mp);

    public String update(PAG_SERVICIOS mp);

    public String delete(int id);

    public List listar_en_linea();

    public String actualizar_estado(int id, String estado);

}
