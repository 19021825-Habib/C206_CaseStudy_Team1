

public class Procedure {

int Procedure_id;
//test

String Procedure_name;
String Procedure_description;
String comment;
public Procedure(int procedure_id, String procedure_name, String procedure_description, String comment) {
	
	this.Procedure_id = procedure_id;
	this.Procedure_name = procedure_name;
	this.Procedure_description = procedure_description;
	this.comment = comment;
}

//test
public int getProcedure_id() {
	return Procedure_id;
}
public String getProcedure_name() {
	return Procedure_name;
}
public String getProcedure_description() {
	return Procedure_description;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}





}
