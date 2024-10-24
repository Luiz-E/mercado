import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtualizarPaginaComponent } from './atualizar-pagina.component';

describe('AtualizarPaginaComponent', () => {
  let component: AtualizarPaginaComponent;
  let fixture: ComponentFixture<AtualizarPaginaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AtualizarPaginaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AtualizarPaginaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
