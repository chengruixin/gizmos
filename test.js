let a = {
    name : "a"
}

let b = {
    name : "b"
}

function swap(){
    let temp = a;
    a = b;
    b = temp;
}

swap();
console.log(a.name, b.name)