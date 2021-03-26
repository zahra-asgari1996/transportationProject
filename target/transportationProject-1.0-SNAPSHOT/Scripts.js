function w3_open() {
    document.getElementById("main").style.marginLeft = "25%";
    document.getElementById("mySidebar").style.width = "25%";
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("openNav").style.display = 'none';
}

function w3_close() {
    document.getElementById("main").style.marginLeft = "0%";
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("openNav").style.display = "inline-block";
}

function CheckPassword()
{
    var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
    if(document.getElementById("pass").value.match(passw))
    {
        return true;
    }else if(document.getElementById("pass").value==""){
        alert('plz fill password !')
        return false;
    }
    else
    {
        alert('Plz inter a valid password !')
        return false;
    }
}

