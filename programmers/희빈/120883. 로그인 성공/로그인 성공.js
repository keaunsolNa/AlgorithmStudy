function solution(id_pw, db) {
  const DBObject = db.reduce((acc, cur) => {
    const [id, pw] = cur
    acc[id] = pw
    return acc
  }, {})

  const [id, pw] = id_pw
  return DBObject[id] ? DBObject[id] === pw ? 'login' : 'wrong pw' : 'fail'
}