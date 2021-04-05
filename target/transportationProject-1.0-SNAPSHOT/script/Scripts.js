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

function Check() {
    var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
    if (document.getElementById("pass").value.match(passw)) {
        return true;
    } else if (document.getElementById("pass").value == "") {
        alert('plz fill password !')
        return false;
    } else if (document.getElementById("userName").value == "") {
        alert('plz fill userName !')
        return false;
    } else if (document.getElementById("name").value == "") {
        alert('plz fill Name !')
        return false;
    } else if (document.getElementById("lname").value == "") {
        alert('plz fill LastName !')
        return false;
    } else if (document.getElementById("email").value == "") {
        alert('plz fill email !')
        return false;
    } else if (document.getElementById("phone").value == "") {
        alert('plz fill phone!')
        return false;
    } else if (document.getElementById("province").value == "") {
        alert('plz fill province!')
        return false;
    } else if (document.getElementById("city").value == "") {
        alert('plz fill city!')
        return false;
    } else if (document.getElementById("address").value == "") {
        alert('plz fill address!')
        return false;
    } else {
        alert('Plz inter a valid password !')
        return false;
    }
}


var city = {};
city['teh'] = ['--City--', 'damavand', 'shahriyar', 'tehran'];
city['Az'] = ['--City--', 'tabriz', 'benab', 'shabestar'];
city['esf'] = ['--City--', 'esfahan', 'shahin shahr', 'natanz'];
city['zan'] = ['--City--', 'zanjan', 'abhar', 'hidaj'];
city['Al'] = ['--City--', 'karaj', 'asara', 'nazarabad'];
city['Azg'] = ['--City--', 'urmia', 'salmas', 'mahabad'];
city['maz'] = ['--City--', 'sari', 'amol', 'ramsar'];
city['fa'] = ['--City--', 'shiraz', 'marvdasht', 'lar'];

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

var city1 = {};
city1['teh'] = ['--City--', 'damavand', 'shahriyar', 'tehran'];
city1['Az'] = ['--City--', 'tabriz', 'benab', 'shabestar'];
city1['esf'] = ['--City--', 'esfahan', 'shahin shahr', 'natanz'];
city1['zan'] = ['--City--', 'zanjan', 'abhar', 'hidaj'];
city1['Al'] = ['--City--', 'karaj', 'asara', 'nazarabad'];
city1['Azg'] = ['--City--', 'urmia', 'salmas', 'mahabad'];
city1['maz'] = ['--City--', 'sari', 'amol', 'ramsar'];
city1['fa'] = ['--City--', 'shiraz', 'marvdasht', 'lar'];

function origin() {

    var provinceList1 = document.getElementById("Oprovince");
    var cityList1 = document.getElementById("Ocity");
    var selCity1 = provinceList1.options[provinceList1.selectedIndex].value;
    while (cityList1.options.length) {
        cityList1.remove(0);
    }
    var cites1 = city1[selCity1];
    if (cites1) {
        var i;
        for (i = 0; i < cites1.length; i++) {
            var c1 = new Option(cites1[i], i);
            cityList1.options.add(c1);
        }
    }
}

var city2 = {};
city2['teh'] = ['--City--', 'damavand', 'shahriyar', 'tehran'];
city2['Az'] = ['--City--', 'tabriz', 'benab', 'shabestar'];
city2['esf'] = ['--City--', 'esfahan', 'shahin shahr', 'natanz'];
city2['zan'] = ['--City--', 'zanjan', 'abhar', 'hidaj'];
city2['Al'] = ['--City--', 'karaj', 'asara', 'nazarabad'];
city2['Azg'] = ['--City--', 'urmia', 'salmas', 'mahabad'];
city2['maz'] = ['--City--', 'sari', 'amol', 'ramsar'];
city2['fa'] = ['--City--', 'shiraz', 'marvdasht', 'lar'];

function destination() {

    var provinceList2 = document.getElementById("Dprovince");
    var cityList2 = document.getElementById("Dcity");
    var selCity2 = provinceList2.options[provinceList2.selectedIndex].value;
    while (cityList2.options.length) {
        cityList2.remove(0);
    }
    var cites2 = city2[selCity2];
    if (cites2) {
        var i;
        for (i = 0; i < cites2.length; i++) {
            var c2 = new Option(cites2[i], i);
            cityList2.options.add(c2);
        }
    }
}

function premium() {
    var weight = document.getElementById("weight").value
    alert('your price is' + weight * 20000 + ' and you receive it after one day')
}

function gold() {
    var weight = document.getElementById("weight").value
    alert('your price is' + weight * 14000 + ' and you receive it after 3 day')
}

function silver() {
    var weight = document.getElementById("weight").value
    alert('your price is' + weight * 10000 + ' and you receive it after 4 day')
}

function show(that) {
    if (that.value == "non") {
        document.getElementById("non-doc").style.display = "block";
    } else {
        document.getElementById("non-doc").style.display = "none";
    }

}

function showPassword() {
    var x = document.getElementById("pass");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}

var num1;
var num2;
var sum;

function captcha() {
    num1 = Math.floor(Math.random() * 10);
    num2 = Math.floor(Math.random() * 10);
    var text = "what is" + " " + num1 + " " + "+" + " " + num2 + ":";
    document.getElementById("ebcaptchatext").innerText = text
    sum = num2 + num1

}

function calc() {
    console.log("num1 :" + num1)
    console.log("num2 :" + num2)
    console.log("sum : " + sum)
    if (sum === document.getElementById("ebcaptchainput").value) {
        return true;
    } else {
        console.log(sum)
        alert('Please enter the security code correctly');
        return false;
    }
}

function checkNewPacket() {
    if (sum != document.getElementById("ebcaptchainput").value) {
        alert('Please enter the security code correctly');
        return false;
    } else if (document.getElementById("Oprovince").value === "") {
        alert('Please fill origin province');
        return false;
    } else if (document.getElementById("Ocity").value === "") {
        alert('Please fill origin city');
        return false;
    } else if (document.getElementById("Oaddress").value === "") {
        alert('Please fill origin address');
    } else if (document.getElementById("Dprovince").value === "") {
        alert('Please fill destination province');
        return false;
    } else if (document.getElementById("Dcity").value === "") {
        alert('Please fill destination city');
        return false;
    } else if (document.getElementById("Daddress").value === "") {
        alert('Please fill destination address');
        return false;
    } else if (document.getElementById("Rname").value === "") {
        alert('Please fill reception name');
        return false;
    } else if (document.getElementById("Rphone").value === "") {
        alert('Please fill reception phone');
        return false;
    } else if (document.getElementById("weight").value === "") {
        alert('Please fill weight');
        return false;
    } else if (document.getElementById("doc").value === "") {
        alert('Please select document or not');
        return false;
    } else {
        return true;
    }


}

function checkOrderNumber() {
    if (document.getElementById("OrderTrackingNumber").value === "") {
        alert("please fill order number");
        return false;
    } else {
        return true;
    }
}




