let timer = null;
let count = 0;

self.onmessage = ({ data }) => {
    if (data?.type === "stop") {
        clearTimeout(timer);
        timer = null;
    } else if (data?.type === "start" && Number.isSafeInteger(data.value) && data.value >= 0) {
        clearTimeout(timer);
        count = data.value;
        postMessage(count);
        tick();
    }
};

function tick() {
    timer = setTimeout(() => {
        count += 1;
        postMessage(count);
        tick();
    }, 500);
}
