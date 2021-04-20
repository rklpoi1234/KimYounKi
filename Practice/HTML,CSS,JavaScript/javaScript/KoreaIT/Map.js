Map = function() {
    this.Map = new Object;
};

// 프로토타입과,in연산자는 맨아래 주석 참조

Map.prototype = {
    //세미콜론전 까진 한뭉터기입니다.
    put : function (key,value)
    //put 키값에[index] value값을 넣어주는 put creat
    {
        this.Map[key] = value;
    },
    //get 이맵함수에 키[index]에있는 값을 돌려준다
    get: function (key) 
    {
        return this.Map[key]; 
    },
    //containskey 말그대로 key가함유되어있는지 boolean타입으로지정 
    //in연산자 key값이 이맵에 있으면 true를돌려줍니다. 오른쪽 객체를명시
    containsKey : function (key) 
    {
        return key in this.Map; 
    },

    //containsValue 위 주석과동일
    //prop 가 이객체에 존재하면 true기때문에 돌아돌아 if문조건이아니면 false
    //이맵[prop]배열안값이 밸류와 똑같으면 true를 돌려줍니다.
    containsValue : function(value)
    {
        for (let prop in this.Map) 
        {
            if (this.Map[prop] == value) return true;
        }
        return false;
    },

    //텅빔 사이즈값을 0으로 돌려준다
    isEmpty : function (key) 
    {
        return (this.size() == 0); 
    },

    //지운다 for prop가 이맵에있으면 돌면서 prop이 인덱스값으로들어가면서삭제
    clear : function () 
    {
        for (let prop in this.Map)
        {
            delete this.Map[prop];
        }
    },

    //특정 키값[인덱스]를 지운다
    remove : function (key)
    {
        delete this.map[key];   
    },
    
    //이것도 위와비슷하고 스택 인덱스를 넣는다
    key : function()
    {
        let keys = new Array();
        for(let prop in this.map)
        {
            keys.push(prop);
        }
        return keys;
    },

    values : function ()
    {
        let values = new Array();
        for(let prop in this.map)
        {
            values.push(this.map[prop]);
        }
        return values;
    },

    //prop가 이앱에 있다면 count를증가시키고 falsle가되면 count값을돌려준다
    //그래서 총 size를 돌려주는거같습니다.
    size : function ()
    {
        let count = 0;
        for(let prop in this.map)
        {
            count++;
        }
        return count;    
    }

};


//프로토타입 https://www.nextree.co.kr/p7323/
//MDN in 연산자 https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/in