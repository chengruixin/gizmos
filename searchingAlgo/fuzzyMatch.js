const minDistance = require("./minDistance");
const getShingles = require("./../utils/getShingles");
function fuzzyMatch(tested, pattern){
    const shingles = getShingles(tested, pattern.length);

    let samllest = Number.MAX_SAFE_INTEGER;
    for(let i = 0; i < shingles.length; i++){
        let tempMin = minDistance(shingles[i], pattern);
        samllest = Math.min(tempMin, samllest);
        
    }

    return samllest;
}

module.exports = fuzzyMatch;