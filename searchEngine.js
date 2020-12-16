const { KmpReturnBoolean } = require("./searchingAlgo/Kmp");
const minDistance = require("./searchingAlgo/minDistance");
const getShingles = require("./utils/getShingles");
const fuzzyMatch = require("./searchingAlgo/fuzzyMatch");
const fs = require('fs');


(function main(){
    // console.log(KmpReturnBoolean("abc", "d"));
    // console.log( minDistance("abc", "d")  );
    // console.log(getShingles("abcdefg", 5));

    try {
<<<<<<< HEAD
        const queryContent = "m1yb";
=======
        const queryContent = "dc2e";
>>>>>>> 2b1dcbdcfcb4455aebacc96882893bb7656da705
        const CASE_ONE = "./case.100.8.txt";
        const CASE_TWO = "./case.1000.12.txt";
        const CASE_THREE = "./case.10000.16.txt";
        const CASE_REAL = "./case.real1.txt";
<<<<<<< HEAD
        const rawData = fs.readFileSync(CASE_THREE, 'utf8')
=======
        const rawData = fs.readFileSync(CASE_ONE, 'utf8')
>>>>>>> 2b1dcbdcfcb4455aebacc96882893bb7656da705
        const strings = rawData.split("\n");
        
        const exactMatching = [];
        const uncertainMathcing = [];
        //find exact match
        for(let i = 0; i < strings.length; i++){
            let comparedString = strings[i].toLowerCase();
            if(KmpReturnBoolean(comparedString, queryContent))
                exactMatching.push(i);
            else{
                let distance = fuzzyMatch(comparedString, queryContent);
                uncertainMathcing.push({
                    index : i,
                    distance : distance
                })
            }
        }

        console.log("\nPrinting exact matchings:");

        for(let i = 0; i < exactMatching.length; i++){
            console.log(strings[exactMatching[i]]);
        }

        const threshold = Math.floor(queryContent.length/3);
        console.log("Printing relative exact matchings:\n")
        for(let i = 0; i < uncertainMathcing.length; i++){
            if(uncertainMathcing[i].distance <= threshold){
                let str = strings[uncertainMathcing[i].index].split("\r")[0];
                let dis = JSON.stringify(uncertainMathcing[i].distance);
                
                console.log(str, dis);
            }
        }
        

    } catch (err) {
        console.error(err)
    }

})();