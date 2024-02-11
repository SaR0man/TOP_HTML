
let menu = document.querySelector(".setMenu");
let body = document.querySelector("body");
let text = document.querySelector(".contentContainer");
let title = document.querySelector(".title");
let subtitle = document.querySelectorAll(".subtitle");

function subtitleFontSize(size) {
  for (let i = 0; i < subtitle.length; i++) {
    subtitle[i].style.fontSize = size;
  }
}

function findCookie(param) {
  let cookies = document.cookie.split(";").map(function (item) {
    return item.trim(); // + избавляемся от символа новой строки
  });
  for (let i = 0; i < cookies.length; i++) {
    let element = cookies[i].split("=");
    if (element[0] == param) {
      return element[1];
    }
  }
}

document.querySelector("#setBtn").addEventListener("click", () => {
  menu.hidden = false;
});

document.querySelector("#close").addEventListener("click", () => {
  menu.hidden = true;
});

document.querySelector("#bGrndClr_1").addEventListener("click", () => {
  body.style.backgroundColor = "antiquewhite";
  document.cookie = "bGrndClr=Light";
});

document.querySelector("#bGrndClr_2").addEventListener("click", () => {
  body.style.backgroundColor = "chocolate";
  document.cookie = "bGrndClr=Dark";
});

document.querySelector("#txtClr_1").addEventListener("click", () => {
  text.style.color = "maroon";
  document.cookie = "txtClr=maroon";
});

document.querySelector("#txtClr_2").addEventListener("click", () => {
  text.style.color = "white";
  document.cookie = "txtClr=white";
});

document.querySelector("#txtSz_1").addEventListener("click", () => {
  text.style.fontSize = "14px";
  title.style.fontSize = "20px";
  subtitleFontSize("17px");
  document.cookie = "txtSz=small";
});

document.querySelector("#txtSz_2").addEventListener("click", () => {
  text.style.fontSize = "16px";
  title.style.fontSize = "25px";
  subtitleFontSize("20px");
  document.cookie = "txtSz=normal";
});

document.querySelector("#txtSz_3").addEventListener("click", () => {
  text.style.fontSize = "18px";
  title.style.fontSize = "30px";
  subtitleFontSize("25px");
  document.cookie = "txtSz=large";
});

document.addEventListener("DOMContentLoaded", () => { 
  console.log(findCookie("bGrndClr"));
  if (findCookie("bGrndClr") == "Light") {
    body.style.backgroundColor = "antiquewhite";
  } else if (findCookie("bGrndClr") == "Dark") {
    body.style.backgroundColor = "chocolate";
  }

  text.style.color = findCookie("txtClr");

  if (findCookie("txtSz") == "small") {
    text.style.fontSize = "14px";
    title.style.fontSize = "20px";
    subtitleFontSize("17px");
  } else if (findCookie("txtSz") == "normal") {
    text.style.fontSize = "16px";
    title.style.fontSize = "25px";
    subtitleFontSize("20px");
  } else if (findCookie("txtSz") == "large") {
    text.style.fontSize = "18px";
    title.style.fontSize = "30px";
    subtitleFontSize("25px");
    }
});
