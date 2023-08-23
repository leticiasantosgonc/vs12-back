db.alunos.insertOne({ "nome": "Leticia Santos", "data_nascimento": Date("06-10-1996")})
db.alunos.insertMany([
  {"nome": "Vitor Nunes", "data_nascimento": Date("1996-06-20")},
  {"nome": "Valeria Santos", "data_nascimento":Date("1965-11-13")},
  {"nome": "Anne Schneider", "data_nascimento":Date("1996-06-20")},
  {"nome": "Leonardo Rosa", "data_nascimento": Date("1998-10-23")}
])

db.alunos.find()
db.alunos.find({"nome": "Vitor Nunes"})
db.alunos.find({"nome": /^L/})
