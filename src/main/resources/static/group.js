function addGroup(){
    var obj = {};
    obj.numb= document.getElementById("nameGroup").value;
    obj.course = document.getElementById("courseGroup").value;
    obj.directionCode = document.getElementById("directionCodeGroup").value;
    obj.direction = document.getElementById("directionGroup").value;
    var json = JSON.stringify(obj);
    console.log(json);
    var XHR = new XMLHttpRequest();
    XHR.open("POST","/group-management/group",true);
    XHR.setRequestHeader('Content-type','application/json; charset=utf-8');
    XHR.send(json);
}
function updateGroup(){
    var obj = {};
    obj.id = document.getElementById("idGroup").value;
    obj.numb= document.getElementById("nameGroup").value;
    obj.course = document.getElementById("courseGroup").value;
    obj.directionCode = document.getElementById("directionCodeGroup").value;
    obj.direction = document.getElementById("directionGroup").value;
    var json = JSON.stringify(obj);
    console.log(json);
    var XHR = new XMLHttpRequest();
    XHR.open("PUT","/group-management/group",true);
    XHR.setRequestHeader('Content-type','application/json; charset=utf-8');
    XHR.send(json);
}
function deleteGroup(){
    var id= document.getElementById("idGroup").value;
    var XHR = new XMLHttpRequest();
    XHR.open("DELETE","/group-management/group/"+ id,true);
    XHR.setRequestHeader('Content-type','application/json; charset=utf-8');
    XHR.send();
}








function getGroup(id){


    var XHR = new XMLHttpRequest();
    XHR.open("GET","/group-management/group/"+id,true);
    XHR.setRequestHeader('Content-type','application/json; charset=utf-8');
    XHR.send();
    if(XHR.status === 200){
        return XHR.responseText;
    }
    else{
        alert("Ошибка " + XHR.status);
    }
}