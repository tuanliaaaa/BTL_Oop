const listcredit=[];
var subjectselect=0;
if (localStorage.getItem("Token") )
{

//    GetSubjectByTermNow();
//    GetSectionClassStudentNow();
}
else
{
    GetSectionClassStudentNow();
    GetSubjectByTermNow();
//    GetSectionClassStudentNow();
//    localStorage.removeItem('Token');
//    window.location='/login';
}
//function LogOut()
//{
//    window.location="/login";
//    localStorage.removeItem('Token');
//}

/*Liệt kê danh sách các môn học đã đăng kí với User và Term Hiện Tại*/
function GetSubjectByTermNow(){
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function()
    {
        if(xhttp.status==403)
        {
            localStorage.removeItem('Token');
            window.location='/login';
        }
        else if(xhttp.status==500)
        {
            document.getElementById("erornotfound").style.display = "block";
            GetSubjectByTermNear();
        }
        var subjectsJsons=xhttp.responseText;
        var subjects= JSON.parse(subjectsJsons);
        if(xhttp.status==200)
        {
            selecSubjectHtml = '';

            for (var i in subjects)
            {
                selecSubjectHtml+='<option value="'+subjects[i]['subjectMajorID']+'">'+subjects[i]['subjectCode']+' - '+subjects[i]['subjectName']+'</option>';
            }
            document.getElementById("selecSubject").innerHTML=selecSubjectHtml;
        }
    }
    xhttp.open("GET", "/SignCredit/AllSubjectSignedByTermNow",false);
    token = localStorage.getItem("Token");
    authorization ='Bearer '+token
    xhttp.setRequestHeader("Authorization",authorization);
    xhttp.send();
}

/* Liệt kê danh sách các môn đã đăng kí trong kì gần nhất*/
function GetSubjectByTermNear(){
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function()
    {
        if(xhttp.status==403)
        {
            localStorage.removeItem('Token');
            window.location='/Account/Login';
        }
        else if(xhttp.status==404)
        {
            document.getElementById("erornotfound").style.display = "block";
        }
        var subjectsJsons=xhttp.responseText;
        var subjects= JSON.parse(subjectsJsons);
        if(xhttp.status==200)
        {
            selecSubjectHtml = '';

            for (var i in subjects)
            {
                selecSubjectHtml+='<option value="'+subjects[i]['subjectMajorID']+'">'+subjects[i]['subjectCode']+' - '+subjects[i]['subjectName']+'</option>';
            }
            document.getElementById("selecSubject").innerHTML=selecSubjectHtml;
        }
    }
    xhttp.open("GET", "/SignCredit/AllSubjectSignedByTermNear",false);
    token = localStorage.getItem("Token");
    authorization ='Bearer '+token
    xhttp.setRequestHeader("Authorization",authorization);
    xhttp.send();
}
// hàm Tìm kiếm môn học bằng mã môn học
function GetMonHoc_changed(){
    var selecSubject=document.getElementById("selecSubject");
    var choosenOption= selecSubject.options[selecSubject.selectedIndex];
    if(choosenOption.value){
        GetCreditByID(choosenOption.value);

    }
}




function GetCreditByID(id){
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function()
    {
        if(xhttp.status==403)
        {
            localStorage.removeItem('Token');
            window.location='/login';
        }
        else if(xhttp.status==404)
        {
            document.getElementById("erornotfound").style.display = "block";

        }
        var creditsJsons=xhttp.responseText;
        var credits= JSON.parse(creditsJsons);
        if(xhttp.status==200)
        {
            subjectselect=id;
            var seleccreditsHtmls = '<thead><tr><th>Trạng Thái</th><th>Mã Môn Học</th><th>Tên Môn Học</th><th>Sĩ số</th><th>Tối Đa</th><th>Giảng Viên</th><th style="width:300px">Danh Sách Ngày Học</th></tr></thead><tbody>';
            for (var i in credits)
            {
                seleccreditsHtmls+='<tr><td id="checkbox" ><input type="checkbox" value="'+credits[i]['classsectionId']+'" onclick= ';

                if(listcredit.includes(credits[i]['classsectionId']))
                {
                    seleccreditsHtmls+=' "DeleteCredit(this)" checked ';
                }
                else{
                    seleccreditsHtmls+=' "PostCredit(this)" '
                }
                seleccreditsHtmls+='> </td><td >'+credits[i]['subjectCode']+'</td><td >'+credits[i]['subjectName']+'</td><td >'+credits[i]['quantityReal']+'</td><td >'+credits[i]['quantity']+'</td> <td >'+credits[i]['teacher']+'</td><td >'+credits[i]['lessonCalender']+'</td></tr>';

            }
            document.getElementById("table__Subjectlist").innerHTML=seleccreditsHtmls+"</tbody>";
        }
    }
    xhttp.open("GET", "/Classsection/AllClasssections/"+id,false);
    token = localStorage.getItem("Token");
    authorization ='Bearer '+token
    xhttp.setRequestHeader("Authorization",authorization);
    xhttp.send();
}


// Đăng kí tín chỉ của môn học
function GetCredit_changed(){

    var selectCredits=document.querySelectorAll(".creditcontent input");
    for(var i=0;i<selectCredits.length;i++){

        selectCredits[i].checked= false;
    }

}
// Liệt Kê các tín chỉ đã đăng kí
function GetSectionClassStudentNow(){
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function()
    {
        if(xhttp.status==403)
        {
            localStorage.removeItem('Token');
            window.location='/login';
        }
        else if(xhttp.status==404)
        {
            document.getElementById("erornotfound").style.display = "block";
        }
        var subjectsJsons=xhttp.responseText;
        var subjects= JSON.parse(subjectsJsons);
        if(xhttp.status==200)
        {

            var selecSubjectHtmls = '<thead><tr><th>Lưu Đăng kí</th><th>Mã Môn Học</th><th>Tên Môn Học</th></tr></thead><tbody>';

            for (var i in subjects)
            {

                if(listcredit.includes(subjects[i]['classSection'])==false)
                {
                    listcredit.push(subjects[i]['classSection']);
                }

                selecSubjectHtmls+='<tr><td id="checkbox" ><input type="checkbox" onclick="DeleteCredit(this)" checked'+' value="'+subjects[i]['classSection']+'"></td><td id="'+subjects[i]['subjectCode']+'">'+subjects[i]['subjectCode']+'</td><td >'+subjects[i]['subjectName']+'</td></tr>';
            }
            document.getElementById("table__CheckSubjectlist").innerHTML=selecSubjectHtmls+"</tbody>";
            GetCreditByID(subjectselect);
        }
    }
    xhttp.open("GET", "/ClasssectionStudent/AllClasssectionStudent",false);
    token = localStorage.getItem("Token");
    authorization ='Bearer '+token
    xhttp.setRequestHeader("Authorization",authorization);
    xhttp.send();
}
// Đăng kí tín chỉ
function PostCredit(credit){
    function getCookie(name)
    {
        var cookieValue = null;
        if (document.cookie && document.cookie !== '')
        {
            var cookies = document.cookie.split(';');
            for (var i = 0; i < cookies.length; i++)
            {
                var cookie = cookies[i].trim();
                // Does this cookie string begin with the name we want?
                if (cookie.substring(0, name.length + 1) === (name + '='))
                {
                    cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                    break;
                }
            }
        }
        return cookieValue;
    }

    var csrfToken = getCookie('csrftoken');
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function()
    {
        var tokenResponseJson=xhttp.responseText
        var tokenResponse= JSON.parse(tokenResponseJson)
        if(xhttp.status==201)
        {



            GetSectionClassStudentNow();

        }
        else if(xhttp.status==404)
        {

            if(tokenResponse["message"]!="Môn đã được đăng kí")
            {
                credit.checked=false;
                alert("trùng lich học");
            }
            else{
                DeleteCredit(credit);
            }

        }
    }
    const CreInfo={
        classsectionID:credit.value
    }
    postData=JSON.stringify(CreInfo)
    xhttp.open("POST", "/ClasssectionStudent/ClasssectionStudents",false);
    xhttp.setRequestHeader("Content-type","application/json");
    token = localStorage.getItem("Token");
    authorization ='Bearer '+token;
    xhttp.setRequestHeader("Authorization",authorization);
    xhttp.setRequestHeader("X-CSRFToken", csrfToken);
    xhttp.send(postData)

}
function DeleteCredit(credit){
    function getCookie(name)
    {
        var cookieValue = null;
        if (document.cookie && document.cookie !== '')
        {
            var cookies = document.cookie.split(';');
            for (var i = 0; i < cookies.length; i++)
            {
                var cookie = cookies[i].trim();
                // Does this cookie string begin with the name we want?
                if (cookie.substring(0, name.length + 1) === (name + '='))
                {
                    cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                    break;
                }
            }
        }
        return cookieValue;
    }
    var csrfToken = getCookie('csrftoken');
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function()
    {
        if(xhttp.status==204)
        {
            listcredit.pop(credit.value);

            GetSectionClassStudentNow();
            if(subjectselect!=0)
            {
                GetCreditByID(subjectselect);
            }

        }
        else if(xhttp.status==404)
        {
            alert("bạn không có quyền sửa");
        }
    }

    xhttp.open("DELETE", "/ClasssectionStudent/ClasssectionStudent/"+credit.value,false);
    xhttp.setRequestHeader("Content-type","application/json")
    xhttp.setRequestHeader("X-CSRFToken", csrfToken);
    token = localStorage.getItem("Token");
    authorization ='Bearer '+token
    xhttp.setRequestHeader("Authorization",authorization);
    xhttp.send();
}