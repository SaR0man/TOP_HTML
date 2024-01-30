// console.dir(window.document.children[0].children[1].children[0]);
// window.document.children[0].children[1].children[0].innerText = "Main Title"

// window.getElementById();
// window.querySelector();
// window.querySelectorAll();
// window.getElementsByClassName();
// window.getElementsByTagName();
// window.getElementsByName();

// let box = document.getElementById('one');
// box.innerText = "Main Title";

// let classes = document.getElementsByClassName('example');
// classes[0].innerText = "Title are changed";

// let h1s = document.getElementsByTagName('h1');
// for (const h1 of h1s) {
//     h1.innerText = "New Title"
// }

// let h1s = document.getElementsByTagName('h1');
// for (let i = 0; i < h1s.length; i++) {
//     if (i % 2 == 0) {
//         h1s[i].innerText = "Even Title";
//     }
// }

let one_element = document.querySelector('h1');
one_element.innerText = "First Title"