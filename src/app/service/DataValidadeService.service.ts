import { HttpClient } from "@angular/common/http";
import { Caminho } from "../url";
import { Injectable } from "@angular/core";
import { Remover } from "../interface/removerLista.interface";
import { DataProduto } from "../interface/Validade.interface";
import { CriarDataValidade } from "../interface/CriarValidade.interface";

@Injectable({
    providedIn: 'root'
})
export class DataValidadeService {
    private url = Caminho.api + 'validade/';

    constructor(private http: HttpClient){}

    salvarValidade(vencimento: CriarDataValidade) {
        return this.http.post<void>(this.url + "criar", vencimento)
    }
    buscarDatas() {
        return this.http.get<DataProduto[]>(this.url+'listar');
    }

    remover(codigoBarra: string , data: Date) {
        return this.http.post<Remover>(this.url + "excluirProduto", {data: data, codigoBarra: codigoBarra})
    }
}