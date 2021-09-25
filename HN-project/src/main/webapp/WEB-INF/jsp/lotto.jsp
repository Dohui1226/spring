<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@font-face { font-family: 'BMJUA'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/BMJUA.woff') format('woff'); font-weight: normal; font-style: normal; }
@keyframes done {
    70% {
        transform: scale(1.2)
    }
    150% {
        transform: scale(1)
    }
}

html {
    font-family: BMJUA
}

*, ::before, ::after {
    box-sizing: border-box
}

body, div, button, h1 {
    font: inherit;
    padding: 0;
    margin: 0;
    border: 0;
    outline: 0;
    background: 0
}

#title {
    font-size: 3rem;
    margin: 2rem 0
}

#wrapper {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 10px
}

#numbers {
    display: flex;
    margin-bottom: 20px;
    padding: 30px;
    border: 3px solid pink;
    border-radius: 20px
}

#numbers .ball {
    width: 80px;
    height: 80px;
    margin-right: 10px;
    line-height: 80px;
    font-size: 48px;
    border-radius: 50%;
    text-align: center;
}


#numbers .ball.done {
    animation: done .5s linear
}

#numbers .ball:last-child {
    margin-right: 0
}


#btn {
    position: relative;
    display: block;
    padding: 1rem 2.5rem 1.6rem;
    background: #fff;
    color: #666;
    border: 2px solid #666;
    border-radius: 6px;
    overflow: hidden;
    transition: .5s;
    user-select: none
}

#btn:hover {
    padding: 1rem 2.5rem 1rem;
    margin-top: .6rem;
    background: #999;
    color: #fff
}

#btn::after {
    content: '';
    position: absolute;
    left: 0;
    bottom: 0;
    display: block;
    height: .6rem;
    width: 100%;
    background-image: repeating-linear-gradient(45deg, #666, #666 1px, transparent 2px, transparent 5px);
    border-top: 1px solid #666;
    transition: .5s
}

#btn:hover::after {
    transform: translateY(.6rem)
}

#btn.hide {
    transform: scale(0)
}

@media screen and (max-width: 800px) {
    #numbers {
        flex-direction: column;
        align-items: center
    }

    #numbers .ball {
        margin-right: 0;
        margin-bottom: 10px
    }

    #numbers .ball:last-child {
        margin-bottom: 0
    }
}
</style>
</head>

<body>
 <div id="wrapper">
        <h1 id="title">자동추첨기</h1>
        <div id="numbers">
            <div class="ball blue">?</div>
           
        </div>
        <button id="btn">추첨시작</button>
    </div>
  
</body>
</html>
<script>

let numbers;

function decryptEffect(element, time) {
    const effect = setInterval(() => {
        element.innerText = Math.floor(Math.random() * 300 + 1); //숫자올라가는거
    }, 10);

    setTimeout(() => {
        const random = Math.floor(Math.random() * numbers.length);
		console.log("numbers"+numbers)
		console.log("numbers.length"+numbers.length)
		console.log("random"+random)
        clearInterval(effect);
		console.log(effect)
        element.classList.add("done");
        element.innerText = numbers[random];
        numbers.splice(random, 1);
    }, time * 3000 + 1000);
}

function lottery() {
    document.querySelectorAll(".ball").forEach((element, index) => {
        element.classList.remove("done");
        decryptEffect(element, index);
    });
}

document.getElementById("btn").addEventListener("click", function () {
   
        numbers = Array.from({ length: 10 }, (_, i) => i + 1); //출력되는것
        btn.classList.add("hide");
        lottery();

    
});

</script>