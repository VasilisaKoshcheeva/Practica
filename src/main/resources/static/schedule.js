function addSchedule(){
   var idTeacher = ((document.getElementById("idTeacher").value));
   var idSubject = ((document.getElementById("idSubject").value));
   var idCabinet = ((document.getElementById("idCabinet").value));
   var idGroup = (document.getElementById("idGroup").value);
    var obj = {};
  //  var teacher={};
   // var subject={};
   // var cabinet={};
   // var group={};
 /*   teacher.id = 1
    teacher.lastName = "Кудрина"
    teacher.firstName = "Мария"
    teacher.middleName = "Александровна"

    subject.id = 1
    subject.name = "Физика"

    cabinet.id = 1
    cabinet.numb = "401-14"

    group.id = 1
    group.numb = "6101"
    group.course = 1;
    group.direction_code = "090301D"
    group.direction = "Информатика и вычислительная техника"

  */
    obj.idTeacher= idTeacher;
    obj.idSubject= idSubject;
    obj.idCabinet= idCabinet;
    obj.idGroup= idGroup;

    obj.timeExam= document.getElementById("timeExam").value;
    obj.dateExam= document.getElementById("dateExam").value;
    var json = JSON.stringify(obj);
    console.log(json);
    var XHR = new XMLHttpRequest();
    XHR.open("POST","/schedule-management/schedule",true);
    XHR.setRequestHeader('Content-type','application/json; charset=utf-8');
    XHR.send(json);
}