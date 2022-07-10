function addSubject(){

    var obj = {};
    obj.name = document.getElementById("nameSubject").value;
    var json = JSON.stringify(obj);
    console.log(json);
    var XHR = new XMLHttpRequest();
    XHR.open("POST","/subject-management/subject",true);
    XHR.setRequestHeader('Content-type','application/json; charset=utf-8');
    XHR.send(json);
}

function updateSubject(){
    var obj = {};
    obj.id = document.getElementById("idSubject").value;
    obj.name= document.getElementById("nameSubject").value;
    var json = JSON.stringify(obj);
    console.log(json);
    var XHR = new XMLHttpRequest();
    XHR.open("PUT","/subject-management/subject",true);
    XHR.setRequestHeader('Content-type','application/json; charset=utf-8');
    XHR.send(json);
}

function deleteSubject(){
    var id= document.getElementById("idSubject").value;
    var XHR = new XMLHttpRequest();
    XHR.open("DELETE","/subject-management/subject/"+ id,true);
    XHR.setRequestHeader('Content-type','application/json; charset=utf-8');
    XHR.send();
}




