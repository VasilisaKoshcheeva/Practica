function addCabinet(){

    var obj = {};
   // obj.id = 999;
    obj.numb= document.getElementById("nameCabinet").value;

    var json = JSON.stringify(obj);
    console.log(json);
    var XHR = new XMLHttpRequest();
    XHR.open("POST","/cabinet-management/cabinet",true);
    XHR.setRequestHeader('Content-type','application/json; charset=utf-8');
    XHR.send(json);
}
function getCabinet(id){


    var XHR = new XMLHttpRequest();
    XHR.open("GET","/cabinet-management/cabinet/"+id,true);
    XHR.setRequestHeader('Content-type','application/json; charset=utf-8');
    XHR.send();
    if(XHR.status === 200){
        return XHR.responseText;
    }
    else{
        alert("Ошибка " + XHR.status);
    }
}