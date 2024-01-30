// let obj = {
//     name: 'John',
//     age: 51
// }

// console.log(obj);
// console.log(obj.name);
// console.log(obj.age);
// obj.surname = 'Malcovich';
// console.log(obj.surname);

// console.log(obj['name']);
// obj['hobby'] = 'fishing';
// console.log(obj.hobby);

// function hi() {
//     console.log('Hello world');
// }

// let myFunc = hi;

// myFunc();

// let name = 'Michael'

// let obj = {
//     name: 'John',
//     age: 51,
//     test: function() {
//         console.log(this.name);
//         console.log(name);
//     }
// }

// obj.test();

//=============================================

// let arr = [1, 2, 3];

// console.log(arr);
// console.log(arr[1]);

// arr[10] = 11;
// console.log(arr);

// let arr = [2, 3, 1, 5, 4];

// for (let i = 0; i < arr.length; i++) {
//     console.log(arr[i]);    
// }

// let arr = [2, 3, 1, 5, 4];

// let i = 0;
// while (true) {
//     if (i == arr.length) {
//         break;
//     }
//     console.log(arr[i++]);
// }

// let arr = [2, 3, 1, 5, 4];

// let i = 0;
// do {
    //     if (i == arr.length) {
        //         break;
        //     }
        //     console.log(arr[i++]);
        // } while (true);
        
        // console.log('Two\nwords');

// let arr = [2, 3, 1, 5, 4];

// for (const i of arr) {
//     console.log(i);
// }

// let arr = [2, 3, 1, 5, 4];

// for (const key in arr) {
//         console.log(key);
// }

// let arr = [2, 3, 1, 5, 4];

// for (const key in arr) {
//     if (arr.hasOwnProperty.call(arr, key)) {
//         const element = arr[key];
//         console.log(element);
//     }
// }

// for (const key in arr) {
//     if (arr.hasOwnProperty.call(arr, key)) {
//         const element = arr[key];
//         console.log('[' + key + '] = ' + element);
//     }
// }

// console.log('log');
// console.error('error');
// console.warn('warning');
// console.info('info');

// try {
//     console.log(10 / 0);
// } catch(e) {
//     console.error('1');
// }

// let arr = [2, 3, 1, 5, 4];

// arr.push(-8);
// arr.unshift(8);
// console.log(arr);

// arr.pop();
// arr.shift();
// console.log(arr);

// let arr = [2, 3, 1, 5, 4];

// arr.splice(2, 2);
// console.log(arr);

// let arr = [2, 3, 1, 5, 4];

// arr.splice(2, 2, 55, 66, 77);
// console.log(arr);

// let arr = [2, 3, 1, 5, 4, 1];

// console.log(arr.lastIndexOf(1));

// console.log(arr.indexOf(1));

// arr.reverse();
// console.log(arr);

// arr.splice(2, 0, 55, 66);
// console.log(arr);

// let arr_1 = [1, 2, 3];
// let arr_2 = [4, 5, 6];

// let arr_3 = arr_1.concat(arr_2);
// console.log(arr_3);

// let arr = [2, 3, 1, 5, 4, 6];

// let result = arr.every(x => x > 0);
// console.log(result);

// function even_odd(num) {
    // if (num % 2 == 0) {
    //     return true;
    // } else {
    //     return false;
    // }
//     return num % 2 == 0;
// }

// let arr_new = arr.filter(x => x % 2 == 0);
// console.log(arr_new);