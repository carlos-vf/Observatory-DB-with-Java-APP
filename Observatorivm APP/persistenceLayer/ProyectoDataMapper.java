package persistenceLayer;

import domain.Proyecto;
import observatorio.domain.DesglosePresupuesto;
import observatorio.domain.DesgloseGasto;
import observatorio.domain.DesgloseGastos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;


public class ProyectoDataMapper{

    public boolean CreaProyecto(Proyecto p){
        Connection con = SqlServerConnectionManager.getConnection();

        try{
            CallableStatement cstmt = null;


            cstmt = con.prepareCall("{call dbo.registroProyecto(?, ?, ?, ?, ?)}");

            cstmt.setString("id",p.getId());
            cstmt.setDate("fechaIni",p.getFechaIni());
            cstmt.setString("estadoProyecto",p.getEstadoProyecto());
            cstmt.setDate("fechaFinEstimada",p.fechaFinEstimada());
            cstmt.setString("descripcion",p.descripcion());

            cstmt.execute();
            return true;


        } catch(SQLException e){
            System.out.println("Error al crear el proyecto");
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizaProyecto(String id, Date fechaIni, Date fechaFin, 
    String estadoProyecto, Date fechaFinEstimada, String descripcion){

            String updateStmText = "update dbo.Proyecto set id="+id+
                ",fechaIni="+fechaIni+",fechaFin=" + fechaFin + ",estadoProyecto=" 
                    + estadoProyecto + ",descrpcion=" + descripcion;


            return SqlServerConnectionManager.executeSqlStatement
                (updateStmText, "Excepci�n al actualizar el proyecto con id " + id);
       }

    public boolean eliminarProyecto(String id){
        String deleteStmText = "DELETE FROM Proyecto WHERE id=" + id + "";
        return SqlServerConnectionManager.executeSqlStatement(deleteStmText,"Excepcion al borrar proyecto con id " + id);
    }

    public boolean actualizarPresupuesto(DesglosePresupuesto dp){
        Connection con = SqlServerConnectionManager.getConnection();

        try{
            CallableStatement cstmt = null;


            cstmt = con.prepareCall("{call dbo.registroDesglosePresupuesto(?, ?, ?, ?)}");

            cstmt.setString("idProyecto",dp.getIdProyecto());
            cstmt.setFloat("cantidad", dp.getCantidad());
            cstmt.setString("descripcion",dp.getDescripcion());
            cstmt.setString("numeroDesglose", dp.getNumeroDesglose());

            cstmt.execute();
            return true;


        } catch(SQLException e){
            System.out.println("Error al crear el presupuesto del proyecto");
            e.printStackTrace();
            return false;
        }
    }

    public boolean registroGasto(DesgloseGastos dg){
        Connection con = SqlServerConnectionManager.getConnection();

        try{
            CallableStatement cstmt = null;


            cstmt = con.prepareCall("{call dbo.registroProyecto(?, ?, ?, ?)}");

            cstmt.setString("idProyecto",dg.getIdProyecto());
            cstmt.setFloat("cantidad", dg.getCantidad());
            cstmt.setString("descripcion", dg.getDescripcion());
            cstmt.setString("numeroDesglose", dg.NumeroDesglose());

            cstmt.execute();

            return true;

        } catch(SQLException e){
            System.out.println("Error al anhadir gasto");
            e.printStackTrace();
            return false;
        }
    }


}