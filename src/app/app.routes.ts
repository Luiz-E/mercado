import { Routes } from '@angular/router';
import { IndexComponent } from './components/index/index.component';
import { AtualizarPaginaComponent } from './components/atualizar-pagina/atualizar-pagina.component';
import { AdicionarPaginaComponent } from './components/adicionar-pagina/adicionar-pagina.component';
import { ListarDatasComponent } from './components/listar-datas/listar-datas.component';
import { AdicionarProdutoComponent } from './components/adicionar-produto/adicionar-produto.component';

export const routes: Routes = [
    {path: "index", component: ListarDatasComponent},
    {path: "", component: ListarDatasComponent},
    {path: "atualizar/:id", component: AtualizarPaginaComponent},
    {path: "salvar", component: AdicionarPaginaComponent},
    {path: "produtos", component: IndexComponent},
    {path: "adicionar", component: AdicionarProdutoComponent}
];
