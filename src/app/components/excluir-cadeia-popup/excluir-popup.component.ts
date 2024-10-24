import { Component, EventEmitter, Output } from '@angular/core';

@Component({
    selector: 'app-excluir-cadeia-popup',
    standalone: true,
    imports: [],
    templateUrl: './excluir-cadeia-popup.component.html',
    styleUrl: './excluir-cadeia-popup.component.css'
})
export class ExcluirCadeiaPopupComponent {

    @Output() close = new EventEmitter<void>();
    @Output() delete = new EventEmitter<void>();

    cancelar() {
        this.close.emit();
    }

    excluir() {
        this.delete.emit();
    }
}
