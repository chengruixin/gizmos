function produceUglyNum(n){
    const dp = [];
    dp[0] = 1;

    let ptr2 = 0;
    let ptr3 = 0;
    let ptr5 = 0;

    for(let i = 1; i < n; i++){
        let min = getMin(dp[ptr2] * 2, dp[ptr3] * 3, dp[ptr5] * 5);

        dp.push(min);

        //move ptrs
        if(dp[ptr2] * 2 === min) ptr2++;
        if(dp[ptr3] * 3 === min) ptr3++;
        if(dp[ptr5] * 5 === min) ptr5++; 
    }

    return dp;
}

function getMin(){
    let min = Number.MAX_SAFE_INTEGER;
    for(let value of arguments){
        if(typeof value !== 'number') continue;
        min = Math.min(min, value);
    }
    return min;
}

(function main(){
    // let dp = produceUglyNum(30);
    // console.log(dp);
    console.log(Math.min(1,2,3));
})();