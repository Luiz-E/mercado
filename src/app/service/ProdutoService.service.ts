import { HttpClient } from "@angular/common/http";
import { Caminho } from "../url";
import { Injectable } from "@angular/core";
import { Produto } from "../interface/produto.interface";

@Injectable({
    providedIn: 'root'
})
export class ProdutoService {
    
    private url = Caminho.api + 'produto/';

    constructor(private http: HttpClient){}

    listar() {
        return this.http.get<Produto[]>(this.url+'listar');
    }

    criarNovo(produto: Produto) {
        return this.http.post<void>(this.url + "salvar", produto)
    }
    buscar(id: string) {
        return this.http.get<Produto>(this.url+'buscarProduto/' + id)
    }

    excluir(id: number) {
        return this.http.delete<void>(this.url + "deletar/"+ id)
    }

    atualizar(produto: Produto) {
        return this.http.put<void>(this.url + "atualizar/"+produto.id, produto)
    }

    excluirTodos(id: number) {
        return this.http.delete<void>(this.url + "deletarTodos/"+ id)
    }
}