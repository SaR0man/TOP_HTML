// async function test() {
//     let result = await fetch('https://omdbapi.com/?s=Rider&apikey=5c3f2d56');
//     let data = await result.json();
//     console.log(data);

//     for (const item of data.Search) {
//         console.log(item.Title);
//     }
// }

// test();

async function searchByTitle(title) {
    let result = await fetch(`https://omdbapi.com/?s=${title}&apikey=5c3f2d56`);
    let data = await result.json();

    return data;
}

let myForm = document.forms.movieSearch;
let list = document.querySelector(".list");

myForm.addEventListener("submit", async () => {
    event.preventDefault();
    let title = myForm.title.value;
    let data = await searchByTitle(title);

    list.innerHTML = '';
    for (const item of data.Search) {
        list.innerHTML += `
        <div class="card col-4">
            <img src="${item.Poster}" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">${item.Title}</h5>
                <p class="card-text">Type: ${item.Type}<br>Year: ${item.Year}</p>
            </div>
        </div>
        `;
    }

    console.log(data);

    myForm.reset();
});
