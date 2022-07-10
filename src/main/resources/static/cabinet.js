function addCabinet(){

    var obj = {};
    obj.numb= document.getElementById("nameCabinet").value;

    var json = JSON.stringify(obj);
    console.log(json);
    var XHR = new XMLHttpRequest();
    XHR.open("POST","/cabinet-management/cabinet",true);
    XHR.setRequestHeader('Content-type','application/json; charset=utf-8');
    XHR.send(json);
}

function updateCabinet(){
    var obj = {};
    obj.id = document.getElementById("idCabinet").value;
    obj.numb= document.getElementById("nameCabinet").value;
    var json = JSON.stringify(obj);
    console.log(json);
    var XHR = new XMLHttpRequest();
    XHR.open("PUT","/cabinet-management/cabinet",true);
    XHR.setRequestHeader('Content-type','application/json; charset=utf-8');
    XHR.send(json);
}

function deleteCabinet(){
    var id= document.getElementById("idCabinet").value;
    var XHR = new XMLHttpRequest();
    XHR.open("DELETE","/cabinet-management/cabinet/"+ id,true);
    XHR.setRequestHeader('Content-type','application/json; charset=utf-8');
    XHR.send();
}
