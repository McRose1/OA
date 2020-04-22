function foo() {
    console.log("first");
    setTimeout(function () {
        console.log('second');
    }, 5);
}

for (var i = 0; i < 4399999999; i++) {
    foo();
}