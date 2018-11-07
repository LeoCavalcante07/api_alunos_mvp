const app = require("express")()
const http = require("http").createServer(app)

const bodyParser = require("body-parser")

//{nome: kassiano, email gmail}
app.use(bodyParser.json())

//{nome=kassaino&emailgmail}
app.use(bodyParser.urlencoded({
    extended:true
}))

let alunos = [{ 
        "id": 1,
        "nome": "Francisco",
        "data_nascimento": 20000125,
        "matricula" : 20858300, 
        "cpf" : "711.301.300-70",
        "notas": [10.0, 8.2, 7.5]
    },
    { 
        "id": 2,
        "nome": "Francisco 2",
        "data_nascimento": 20000126,
        "matricula" : 20858306, 
        "cpf" : "711.301.300-71",
        "notas": [9.0, 4.5, 7.2]
    },]

let idAluno = 2

app.get("/alunos", (req,res)=> res.send(alunos))


app.get("/aluno/:id", (req, res)=> {
	const aluno = alunos.filter(alunos => alunos.id == req.params.id)
	res.send(aluno[0])
})




app.get("/aluno/deletar/:id", (req, res)=> {
	const aluno = alunos.filter(alunos => alunos.id != req.params.id)
	res.send(aluno)
});


app.post("/novo", (req, res)=> {
  
    idAluno ++
    const nome = req.body.nome
    const data_nascimento = req.body.data_nascimento
    const matricula = req.body.matricula
    const cpf = req.body.cpf
    const id = idAluno
    const notas = []
    
    const novoAluno = { 
                       id, 
                       nome,
                       data_nascimento,
                       matricula,
                       cpf, 
                       notas
                      }
    
    alunos.push(novoAluno)
    res.send({ "sucesso" :true, "msg": "Add com sucesso" })    
})


app.get("/",(req, res)=> {    
    res.send("Bem vindo a API de Alunos")
})


http.listen(5001, ()=> {
    console.log("Server running on http://localhost:5001")
})