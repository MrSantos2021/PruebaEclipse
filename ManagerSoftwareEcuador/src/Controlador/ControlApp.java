package Controlador;

import DAO.ConexBD;
import Vista.FormCont_BalanceIni;
import Vista.FormCont_DiarioGeneral;
import Vista.FormularioAddEmpresa;
import Vista.FormularioCargoFuncion_Crear;
import Vista.FormularioChangeEmpresa;
import Vista.FormularioLocal;
import Vista.FormularioLogin;
import Vista.FormularioPersonal;
import Vista.FormularioPersonalAsignar;
import Vista.VentanaPrincipal;


public class ControlApp {
	private ConexBD connex = new ConexBD();
	
	private ControlFormularioLogin cfl = new ControlFormularioLogin();
	private ControlFormularioAddCompany cfac = new ControlFormularioAddCompany();
	private ControlFormularioChangeEmpresa cfce = new ControlFormularioChangeEmpresa();
	private ControlVentanaPrincipal cvp = new ControlVentanaPrincipal();
	private ControlFormularioLocal cflocal = new ControlFormularioLocal();
	private ControlFormularioFuncion cfcargo = new ControlFormularioFuncion();
	private ControlFormularioEmpleado cfeempleado = new ControlFormularioEmpleado();
	private ControlFormularioEmpleadoAsignar cfea = new ControlFormularioEmpleadoAsignar();
	private ControlFinancieroBalanceInicial cfbi = new ControlFinancieroBalanceInicial();
	private ControlFinancieroDG cfdg = new ControlFinancieroDG();
	
	private FormularioLogin fl = new FormularioLogin();
	private FormularioAddEmpresa fae = new FormularioAddEmpresa();
	private FormularioChangeEmpresa fce = new FormularioChangeEmpresa();
	private VentanaPrincipal vp = new VentanaPrincipal();
	private FormularioLocal formLocal;
	private FormularioCargoFuncion_Crear formCargo;
	private FormCont_BalanceIni formBalanceIni;
	private FormCont_DiarioGeneral formDg;
	private FormularioPersonal formPersonal;
	private FormularioPersonalAsignar formAsigPerson;
	
	public ControlApp() {
		// TODO Auto-generated constructor stub
		/*Control Login*/
		cfl.cfl_ventanaLogin(fl, fl.ventanaInicio, connex);
		cfl.cfl_ConectarBD(fl, connex);
		cfl.cfl_ingresarLog(fl, vp, connex);
		cfl.cfl_addCompany(fl, fae);
		
		cfl.cfl_changeCompany(fl, fce, connex);
	
		/*Control Form Add Empresa*/
		cfac.fae_ventanaFormAddEmpresa(fae, fl);
		cfac.addEmpresa(fae, fl, connex);
		
		/*Control Form Change Empresa*/
		cfce.fce_cambiarEmpresas(fce, fl, connex);
		
		/*Control Ventana Principal*/
		cvp.vp_ventanaPrincipal(vp, connex, fl);
		/*Control Formulario Local*/
		formLocal = new FormularioLocal();
		cflocal.local_ventana(vp, formLocal, connex);
		
		formCargo = new FormularioCargoFuncion_Crear();
		cfcargo.funcion_ventanaFormulario(vp, formCargo, connex);
		
		
		formBalanceIni = new FormCont_BalanceIni();
		cfbi.ventana_balanceInicial(vp, formBalanceIni, connex);
		
		formDg = new FormCont_DiarioGeneral();
		cfdg.ventana_DiarioGeneral(vp, formDg);
		
		formPersonal = new FormularioPersonal();
		cfeempleado.cfe_empleado(vp, formPersonal, connex);
		
		formAsigPerson = new FormularioPersonalAsignar();
		cfea.asignar_ventanaFormulario(vp, formAsigPerson, connex);
	}
}