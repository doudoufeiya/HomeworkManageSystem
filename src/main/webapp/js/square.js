// 浠ｈ〃淇勭綏鏂柟鍧楃殑閫氱敤閫昏緫锛屾瘮濡傝宸︾Щ锛屽彸绉伙紝缈昏浆绛夐€昏緫
var Square = function() {
    // 鏂瑰潡鐨勬暟鎹�
    this.data = [
        [0, 0, 0, 0],
        [0, 0, 0, 0],
        [0, 0, 0, 0],
        [0, 0, 0, 0]
    ];

    // 鍘熺偣
    this.origin = {
        x: 0,
        y: 0
    }

    // 鏂瑰悜
    this.dir = 0;
}

// 鏃嬭浆
Square.prototype.canRotate = function(isValid) {
    var d = (this.dir + 1) % 4;
    var test = [
        [0, 0, 0, 0],
        [0, 0, 0, 0],
        [0, 0, 0, 0],
        [0, 0, 0, 0]
    ];
    for (var i = 0; i < this.data.length; i++) {
        for (var j = 0; j < this.data[0].length; j++) {
            test[i][j] = this.rotates[d][i][j];
        }
    }
    return isValid(this.origin, test);
}
Square.prototype.rotate = function(num) {
    if (!num) num = 1;
    this.dir = (this.dir + num) % 4;
    for (var i = 0; i < this.data.length; i++) {
        for (var j = 0; j < this.data[0].length; j++) {
            this.data[i][j] = this.rotates[this.dir][i][j];
        }
    }
}

// 涓嬬Щ
Square.prototype.canDown = function(isValid) {
    var test = {};
    test.x = this.origin.x + 1;
    test.y = this.origin.y;
    return isValid(test, this.data);
}
Square.prototype.down = function() {
    this.origin.x = this.origin.x + 1;
}

// 宸︾Щ
Square.prototype.canLeft = function(isValid) {
    var test = {};
    test.x = this.origin.x;
    test.y = this.origin.y - 1;
    return isValid(test, this.data);
}
Square.prototype.left = function() {
    this.origin.y = this.origin.y - 1;
}

// 鍙崇Щ
Square.prototype.canRight = function(isValid) {
    var test = {};
    test.x = this.origin.x;
    test.y = this.origin.y + 1;
    return isValid(test, this.data);
}
Square.prototype.right = function() {
    this.origin.y = this.origin.y + 1;
}
