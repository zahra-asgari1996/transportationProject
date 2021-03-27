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



var city = {};
city['teh'] = ['damavand', 'shahriyar'];
city['Az'] = ['tabriz', 'benab'];
city['esf'] = ['esfahan'];
function ChangeCityList() {

    var provinceList = document.getElementById("province");
    var cityList = document.getElementById("city");
    var selCity = provinceList.options[provinceList.selectedIndex].value;
    while (cityList.options.length) {
        cityList.remove(0);
    }
    var cites = city[selCity];
    if (cites) {
        var i;
        for (i = 0; i < cites.length; i++) {
            var c = new Option(cites[i], i);
            cityList.options.add(c);
        }
    }
}
function premium(){
    var weight=document.getElementById("weight").value
    alert('your price is'+weight*20000 + ' and you receive it after one day')
}
function gold(){
    var weight=document.getElementById("weight").value
    alert('your price is'+weight*14000 + ' and you receive it after 3 day')
}
function silver(){
    var weight=document.getElementById("weight").value
    alert('your price is'+weight*10000 + ' and you receive it after 4 day')
}
function show(that){
    if (that.value=="non-doc"){
        document.getElementById("non-doc").style.display = "block";
    }else {
        document.getElementById("non-doc").style.display = "none";
    }

}

