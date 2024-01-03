function solution(name, yearning, photo) {
  const point = name.reduce((newObj, obj, index) => {
    newObj[obj] = yearning[index]
    return newObj
  }, {})

  return photo.map(list => list.reduce((acc, cur) => acc + (point[cur] || 0), 0))
}