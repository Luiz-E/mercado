import { Produto } from "./produto.interface";

export interface DataProduto {
    id: number | null;
    dataIncompleta: boolean;
    data: Date;
    dataFormatada: string
    produtos: Produto[]
  }