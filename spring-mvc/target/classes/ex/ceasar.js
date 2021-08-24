/**
 * 암호화 복호화 하는 js
 */
module.export = {
	encrypt: function encript(shift, plaintext){
		return ceasar(shift, plaintext)
	}
	,
	decrypt: function decrypt(shift, ciphertext){
		return ceasar((26-shift)%26 , ciphertext)
	}
	
	
}


function ceasar(shift, input){
	if(!/^-?\d+$/.text(shift)) console.error('Shift is not an integer')
	if(shift < 0 || shift >=26) console.error('Shift is out of range')
	var output = '', len= input.length
	for(var i = 0; i <len; i++){
		var c = input.charCodeAt(i);
		//small fix for cedilla
		if(c==231)
		c=99;
		if(c==199)
		c=67;
		if(c >=65 && c<=90){//upcase
			output +=String.fromCharCode((c - 65 + shift) % 26 + 65)
		}
		else if (c >= 97 &&c <= 122){//downcase
			output += String.fromCharCode((c - 97 + shift)% 26 + 97)
		}
		else{//copy thru
			output +=input.charAt(i)
		}
		
		
	}
	return output
}


console.log(ceasar.decrypt(3, "kl krz dub"));  