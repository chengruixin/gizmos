function computeNext(pattern){
    if(pattern <= 0) return [];

    const next = new Array(pattern.length);

    let prefix = 0;
    next[0] = 0;

    for( let suffix = 1; suffix < next.length; suffix++ ){
        while(prefix > 0 && pattern.charAt(prefix) !== pattern.charAt(suffix))
            prefix = next[prefix - 1];
        
        if(pattern.charAt(prefix) === pattern.charAt(suffix))
            prefix++;
        
        next[suffix] = prefix;
    }

    return next;
}

function Kmp(tested, pattern){
    const ans = [];
    //get next
    const next = computeNext(pattern);

    //right move the next
    for(let i = next.length - 1; i >= 1; i--){
        next[i] = next[i - 1];
    }
    next[0] = -1;

    //assign pointers to these two strings
    let ttPtr = 0;
    let ptPtr = 0;

    while(ttPtr < tested.length){
        if(tested.charAt(ttPtr) === pattern.charAt(ptPtr)){
            ttPtr++;
            ptPtr++;

            if(ptPtr === pattern.length){ // found matched
                ans.push( ttPtr - pattern.length);
                ttPtr--;
                ptPtr = 0;
            }
            continue;
        }

        if(next[ptPtr] !== -1){
            ptPtr = next[ptPtr];
            continue;
        }

        ttPtr++;
        
    }

    return ans;

}


(function main(){
    //test
    let tested = "abababababa";
    let pattern = "aba";

    let ans = Kmp(tested, pattern);
    console.log(ans);
    return 0;
})();