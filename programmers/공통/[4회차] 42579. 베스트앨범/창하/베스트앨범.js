function solution(genres, plays) {
    let playTime = {};
    //1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다
    //장르와 총 재생된 횟술를 담는 객체 out : {classic : 1450, pop: 3100}
    genres.forEach((item, index) => {
        playTime[item] = playTime[item]
            ? playTime[item] + plays[index]
            : plays[index];
});
let albumSong = {}; // 앨범에 수록될 노래 객체

//2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
//3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
return genres
    .map((item, index) => ({ genres: item, plays: plays[index], index }))
        .sort((a, b) => {
            //1. 총 재생 횟수가 많은 장르순으로 정렬
            if (a.genres !== b.genres) return playTime[b.genres] - playTime[a.genres];
            //2. 같은 장르중 재생 횟수가 많은순으로 정렬
            if (a.plays !== b.plays) return b.plays - a.plays;
            //3. 같은 장르 같은 재생 횟수중 고유번호(인덱스)가 낮은순으로 정렬
            return a.index - b.index;
        })
        .filter((item) => {// 정렬된 곡들중 장르별 두곡씩만 선정
            if (albumSong[item.genres] >= 2) return false;
            albumSong[item.genres] = albumSong[item.genres]
                ? albumSong[item.genres] + 1
                : 1;
            return true;
        })
        .map((item) => item.index);
}