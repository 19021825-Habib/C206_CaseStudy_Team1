
public class Procedure {

int Procedure_id;

String Procedure_name;
String Procedure_description;
public Procedure(int procedure_id, String procedure_name, String procedure_description) {
	
	Procedure_id = procedure_id;
	Procedure_name = procedure_name;
	Procedure_description = procedure_description;
}
public int getProcedure_id() {
	return Procedure_id;
}
public String getProcedure_name() {
	return Procedure_name;
}
public String getProcedure_description() {
	return Procedure_description;
}





}
