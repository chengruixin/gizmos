function Compressor(){
    const reader = new FileReader()
    const img = new Image();
    const canvas = document.createElement('canvas');
    const ctx = canvas.getContext('2d');

    const handleFileUpload = (e)=>{
        // console.log(e.target);
        const inputDom = e.target;
        // console.log(inputDom.files);
        const file = inputDom.files[0];

        reader.readAsDataURL(file);
    }

    reader.onload = (e)=>{
        img.src = e.target.result;
    }

    img.onload = ()=>{
        const originWidth = img.width;
        const originHeight = img.height;

        console.log(originWidth, originHeight);

        const targetWidth = Math.floor(originWidth/5);
        const targetHeight = Math.floor(originHeight/5);
        canvas.width = targetWidth;
        canvas.height = targetHeight;
        //draw ima
        ctx.clearRect(0, 0, targetWidth, targetWidth);
        ctx.drawImage(img, 0,0, targetWidth, targetHeight);

        let imgUrl = canvas.toDataURL('img/png', 1);
        console.log(imgUrl);

        var link = document.createElement('a');
        link.download = 'noname.png';
        link.href = imgUrl;
        link.click();
        link.remove();
    }

   


    return (
        <>
           <input type="file" onChange={handleFileUpload} />
        </>
    )
}

export default Compressor;