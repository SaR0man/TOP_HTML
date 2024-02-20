// async function test() {
//     let result = await fetch('https://omdbapi.com/?s=Rider&apikey=5c3f2d56');
//     let data = await result.json();
//     console.log(data);

//     for (const item of data.Search) {
//         console.log(item.Title);
//     }
// }

// test();

async function searchByTitle(title, page = 1) {
    let result = await fetch(`https://omdbapi.com/?s=${title}&apikey=5c3f2d56&page=${page}`);
    let data = await result.json();

    return data;
}

let myForm = document.forms.movieSearch;
let list = document.querySelector(".list");
let title;
let page = 1;

async function renderMovieByTitle(title, page) {
    let data = await searchByTitle(title, page);

    list.innerHTML = '';
    for (const item of data.Search) {
        list.innerHTML += `
        <div class="card col-4">
            <img src="${item.Poster}" onerror="event.target.src='./img/image-not-found.jpg'"  class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">${item.Title}</h5>
                <p class="card-text">Type: ${item.Type}<br>Year: ${item.Year}</p>
            </div>
        </div>
        `;
    }

    let count = data.totalResults;
    let sizePage = Math.ceil(count / 10);

    renderPagination(sizePage);

    console.log(data);
}

myForm.addEventListener("submit", async () => {
    event.preventDefault();

    title = myForm.title.value;

    await renderMovieByTitle(title, page);
    
    myForm.reset();

});

let ul = document.querySelector('.pagination')

function renderPagination(page) {
    ul.innerHTML = '';
    ul.innerHTML += '<li class="page-item"><a class="page-link">Previous</a></li>';
    for (let i = 1; i <= page; i++) {
        ul.innerHTML += `<li class="page-item"><a class="page-link">${i}</a></li>`;
    }
    ul.innerHTML += '<li class="page-item"><a class="page-link">Next</a></li>';
}

document.querySelector('.pagination').addEventListener('click', async ()=>{
    await renderMovieByTitle(title, event.target.innerText);
})

// document.querySelectorAll('img').addEventListener('error')