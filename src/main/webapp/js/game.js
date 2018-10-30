// 俄罗斯方块的核心

var Game = function() {
    // dom元素
    var gameDiv,
        nextDiv,
        //superDiv,
        scoreDiv,
        resultDiv;

    // 分数
    var score = 0;

    // 展示类型
    var superType = 0;

    // 游戏区域矩阵
    var gameData = [
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    ];

    // 当前方块
    var cur;

    // 下一个方��?
    var next;

    //var supers;
    //var superSquare = new SuperSquare();;

    // divs
    var nextDivs = [];
    var gameDivs = [];
    //var superDivs = [];

    // 设置时间
    var setTime = function(time) {
        document.getElementById("time").innerText = time;
    }

    // 初始化div
    var initDiv = function(container, data, divs) {
        for (var i = 0; i < data.length; i++) {
            var div = [];
            for (var j = 0; j < data[0].length; j++) {
                var newNode = document.createElement("div");
                newNode.className = "none";
                newNode.style.top = (i * 20) + "px";
                newNode.style.left = (j * 20) + "px";
                container.appendChild(newNode);
                div.push(newNode);
            }
            divs.push(div);
        }
    };

    //刷新div
    var refurbishDiv = function(data, divs) {
        for (var i = 0; i < data.length; i++) {
            for (var j = 0; j < data[0].length; j++) {
                if (data[i][j] == 0) {
                    divs[i][j].className = "none";
                } else if (data[i][j] == 1) {
                    divs[i][j].className = "done";
                } else if (data[i][j] == 2) {
                    divs[i][j].className = "current";
                }
            }
        }
    };

    // 检测点是否合法
    var check = function(pos, x, y) {
        if (pos.x + x < 0) {
            return false;
        } else if (pos.x + x >= gameData.length) {
            return false;
        } else if (pos.y + y < 0) {
            return false;
        } else if (pos.y + y >= gameData[0].length) {
            return false;
        } else if (gameData[pos.x + x][pos.y + y] === 1) {
            return false;
        } else {
            return true;
        }
    };

    // 检测数据是否合��?
    var isValid = function(pos, data) {
        for (var i = 0; i < data.length; i++) {
            for (var j = 0; j < data[0].length; j++) {
                if (data[i][j] != 0) {
                    if (!check(pos, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // 设置数据
    var setData = function() {
        for (var i = 0; i < cur.data.length; i++) {
            for (var j = 0; j < cur.data[0].length; j++) {
                if (check(cur.origin, i, j)) {
                    gameData[cur.origin.x + i][cur.origin.y + j] = cur.data[i][j];
                }
            }
        }
    };

    // 清除数据
    var clearData = function() {
        for (var i = 0; i < cur.data.length; i++) {
            for (var j = 0; j < cur.data[0].length; j++) {
                if (check(cur.origin, i, j)) {
                    gameData[cur.origin.x + i][cur.origin.y + j] = 0;
                }
            }
        }
    };


    // 下移
    var down = function() {
        if (cur.canDown(isValid)) {
            clearData();
            cur.down();
            setData();
            refurbishDiv(gameData, gameDivs);
            return true;
        } else {
            return false;
        }
    }

    // 左移
    var left = function() {
        if (cur.canLeft(isValid)) {
            clearData();
            cur.left();
            setData();
            refurbishDiv(gameData, gameDivs);
        }
    }

    // 右移
    var right = function() {
        if (cur.canRight(isValid)) {
            clearData();
            cur.right();
            setData();
            refurbishDiv(gameData, gameDivs);
        }
    }

    // 旋转
    var rotate = function() {
        if (cur.canRotate(isValid)) {
            clearData();
            cur.rotate();
            setData();
            refurbishDiv(gameData, gameDivs);
        }
    }

    // 方块移动到底部固��?
    var fixed = function() {
        for (var i = 0; i < cur.data.length; i++) {
            for (var j = 0; j < cur.data[0].length; j++) {
                if (check(cur.origin, i, j)) {
                    if (gameData[cur.origin.x + i][cur.origin.y + j] == 2) {
                        gameData[cur.origin.x + i][cur.origin.y + j] = 1;
                    }
                }
            }
        }
        refurbishDiv(gameData, gameDivs);
    }

    // 消行
    var checkClear = function() {
        var line = 0;
        for (var i = gameData.length - 1; i >= 0; i--) {
            var clear = true;
            for (var j = 0; j < gameData[0].length; j++) {
                if (gameData[i][j] != 1) {
                    clear = false;
                    break;
                }
            }
            if (clear) {
                line += 1;
                for (var m = i; m > 0; m--) {
                    for (var n = 0; n < gameData[0].length; n++) {
                        gameData[m][n] = gameData[m - 1][n];
                    }
                }
                for (var n = 0; n < gameData[0].length; n++) {
                    gameData[0][n] = 0;
                }
                i++;
            }
        }
        return line;
    }

    // 检查游戏结��?
    var checkGameOver = function() {
        var gameOver = false;
        for (var i = 0; i < gameData[0].length; i++) {
            if (gameData[1][i] === 1) {
                gameOver = true;
            }
        }
        return gameOver;
    }

    // var findDepth = function(row, rank) {
    //     if (row === 20)
    //     {
    //         return -1;
    //     }
    //     else {
    //         for (var i = 0; i < gameData[0].length; i++) {
    //             if (gameData[row][i] === 0) {
    //                 if(rank[i] )
    //             }
    //         }
    //     }
    // }
    //
    // var checkHelp = function() {
    //     var row;
    //     var column;
    //     var rank = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1];
    //     for (var i = 0; i < gameData[0].length; i++) {
    //         for (var j = 0; j < gameData.length; j++) {
    //             if (gameData[j][i] === 1) {
    //                 row = j;
    //                 findDepth(row, rank);
    //             }
    //         }
    //     }
    // }

    // 把小视窗方块放到游戏里，并生成新的方��?
    var performNext = function(type, dir) {
      var line;
      var flag = 0;
      for (var i = 0; i < gameData.length; i++) {
        for (var j = 0; j < gameData[0].length; j++) {
          if (gameData[i][j] == 1) {
            flag = 1;
            break;
          }
        }
        if (flag == 1) {
          line = i;
          break;
        }
      }
      if (line > 15 && score > 1000)
      {
        superType += 1;
        supersquare = new superSquare(superType);

        cur = supersquare;
        setData();

      }else if (line < 6) {
        supersquare = new superSquare(0);

        for (var j = 0; j < gameData[0].length; j++) {
          for (var i = 0; i < supersquare.data.length; i++) {
            if (i + line -1 < 20)
            {
              if (gameData[i + line -1][j] == 0) {
                  supersquare.data[i][j] = 2;
              }
              else {
                break;
              }
            }
          }
        }

        cur = supersquare;
        setData();

      }else {
        cur = next;
        setData();
        next = SquareFactory.prototype.make(type, dir);
      }

      // cur = next;
      // setData();
      // next = SquareFactory.prototype.make(type, dir);

      refurbishDiv(gameData, gameDivs);
      refurbishDiv(next.data, nextDivs);
    }

    // 初始��?
    var init = function(doms, type, dir) {
        gameDiv = doms.gameDiv;
        nextDiv = doms.nextDiv;
        //superDiv = doms.superDiv;
        scoreDiv = doms.scoreDiv;
        resultDiv = doms.resultDiv;
        // cur = SquareFactory.prototype.make(3, 2);
        next = SquareFactory.prototype.make(type, dir);

        //superSquare = new SuperSquare();

        //supers = SquareFactory.prototype.make(type, dir);//修改

        initDiv(gameDiv, gameData, gameDivs);
        initDiv(nextDiv, next.data, nextDivs);
        //initDiv(superDiv, supers.data, superDivs);
        // setData();
        // refurbishDiv(gameData, gameDivs);
        refurbishDiv(next.data, nextDivs);
        //refreshDiv(supers.data, superDivs);
    };

    // 分数增加
    var addScore = function(line) {
        var s = 0;
        s = line * (line + 1) * 5;
        score = score + s;
        scoreDiv.innerText = score;
    }

    // 界面显示游戏结束
    var gameOver = function(win) {
        if (win) {
            resultDiv.innerText = "YOU WIN!"
        } else {
            resultDiv.innerText = "GAME OVER!"
        }

    }

    // 导出API
    this.init = init;
    this.down = down;
    this.left = left;
    this.right = right;
    this.rotate = rotate;
    this.fall = function() {
        while (down());
    };
    this.fixed = fixed;
    this.performNext = performNext;
    this.checkClear = checkClear;
    this.checkGameOver = checkGameOver;

    this.setTime = setTime;
    this.addScore = addScore;

    this.gameOver = gameOver;

    this.gameData = gameData;

}
