// obj 需要移动的元素
// dir 方向
// step 步长
// target 目标位置
// fn 回调函数
const doMove = (obj,dir,step,target,fn) => {
    let start = parseInt(getComputedStyle(obj)[dir]);
    step = start > target ? -step : step;
    clearInterval(obj.timer);
    obj.timer = setInterval(() => {
        let dis = parseInt(getComputedStyle(obj)[dir]);
        dis += step;
        if (dis >= target && step > 0 || dis <= target && step < 0) {
            dis = target;
            clearInterval(obj.timer);
            fn && fn();
        }
        obj.style[dir] = dis + 'px';
    }, 30)
}

const doOp = (obj,dir,step,target,fn) => {
    let start = parseFloat(getComputedStyle(obj)[dir]);
    step = start > target ? -step : step;
    clearInterval(obj.timer);
    obj.timer = setInterval(() => {
        let dis = parseFloat(getComputedStyle(obj)[dir]);
        dis += step;
        if (dis >= target && step > 0 || dis <= target && step < 0) {
            dis = target;
            clearInterval(obj.timer);
            fn && fn();
        }
        obj.style[dir] = dis;
    }, 100)
}
